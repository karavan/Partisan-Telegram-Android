package org.telegram.messenger.partisan.secretgroups;

public enum InnerEncryptedChatState {
    CREATING_ENCRYPTED_CHAT,
    NEED_SEND_INVITATION,
    INVITATION_SENT,
    WAITING_SECONDARY_CHATS_CREATION,
    NEED_SEND_SECONDARY_INVITATION,
    INITIALIZED,
    INITIALIZATION_FAILED,
    CANCELLED
}
