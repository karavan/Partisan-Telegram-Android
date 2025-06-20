package org.telegram.messenger.partisan.secretgroups;

public enum EncryptedGroupState {
    CREATING_ENCRYPTED_CHATS,
    JOINING_NOT_CONFIRMED,
    WAITING_CONFIRMATION_FROM_MEMBERS,
    WAITING_CONFIRMATION_FROM_OWNER,
    WAITING_SECONDARY_CHAT_CREATION,
    INITIALIZED,
    INITIALIZATION_FAILED,
    CANCELLED,
    NEW_MEMBER_JOINING_NOT_CONFIRMED,
    NEW_MEMBER_WAITING_SECONDARY_CHAT_CREATION,
}
