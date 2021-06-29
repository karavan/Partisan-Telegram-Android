package org.telegram.messenger.fakepasscode;

import android.content.Context;
import android.content.SharedPreferences;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.telegram.messenger.ApplicationLoader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveAsReadMessages {
    public static class RemoveAsReadMessage {
        private String message;
        private int date;
        private int scheduledTimeMs;

        public RemoveAsReadMessage() {
        }

        public RemoveAsReadMessage(String message, int date, int scheduledTimeMs) {
            this.message = message;
            this.date = date;
            this.scheduledTimeMs = scheduledTimeMs;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getDate() {
            return date;
        }

        public void setDate(int date) {
            this.date = date;
        }

        public int getScheduledTimeMs() {
            return scheduledTimeMs;
        }

        public void setScheduledTimeMs(int scheduledTimeMs) {
            this.scheduledTimeMs = scheduledTimeMs;
        }
    }

    public static Map<String, Map<String, List<RemoveAsReadMessage>>> messagesToRemoveAsRead = new HashMap<>();
    private static final Object sync = new Object();
    private static boolean isLoaded = false;

    public static void loadMessages() {
        synchronized (sync) {
            if (isLoaded) {
                return;
            }

            try {
                SharedPreferences preferences = ApplicationLoader.applicationContext.getSharedPreferences("removeasreadmessages", Context.MODE_PRIVATE);
                ObjectMapper mapper = new ObjectMapper();
                mapper.enableDefaultTyping();
                String messagesToRemoveAsReadString = preferences.getString("messagesToRemoveAsRead", null);
                messagesToRemoveAsRead = mapper.readValue(messagesToRemoveAsReadString, HashMap.class);
                isLoaded = true;
            } catch (Exception ignored) {
                System.err.println("Error in loading messages!");
            }
        }
    }

    public static void saveMessages() {
        synchronized (sync) {
            try {
                SharedPreferences preferences = ApplicationLoader.applicationContext.getSharedPreferences("removeasreadmessages", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                ObjectMapper mapper = new ObjectMapper();
                mapper.enableDefaultTyping();
                String messagesToRemoveAsReadString = mapper.writeValueAsString(messagesToRemoveAsRead);
                editor.putString("messagesToRemoveAsRead", messagesToRemoveAsReadString);
                editor.commit();
            } catch (Exception ignored) {
                System.err.println("Error in commiting messages!");
            }
        }
    }
}