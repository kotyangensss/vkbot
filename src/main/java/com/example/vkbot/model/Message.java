package com.example.vkbot.model;

import java.util.List;

public class Message {
    private long date;
    private int fromId;
    private int id;
    private int out;
    private int peerId;
    private String text;
    private int conversationMessageId;
    private List<Object> fwdMessages;
    private boolean important;
    private int randomId;
    private List<Object> attachments;
    private boolean isHidden;

    public long getDate() {
        return date;
    }

    public void setDate(long date) {
        this.date = date;
    }

    public int getFromId() {
        return fromId;
    }

    public void setFromId(int fromId) {
        this.fromId = fromId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOut() {
        return out;
    }

    public void setOut(int out) {
        this.out = out;
    }

    public int getPeerId() {
        return peerId;
    }

    public void setPeerId(int peerId) {
        this.peerId = peerId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getConversationMessageId() {
        return conversationMessageId;
    }

    public void setConversationMessageId(int conversationMessageId) {
        this.conversationMessageId = conversationMessageId;
    }

    public List<Object> getFwdMessages() {
        return fwdMessages;
    }

    public void setFwdMessages(List<Object> fwdMessages) {
        this.fwdMessages = fwdMessages;
    }

    public boolean isImportant() {
        return important;
    }

    public void setImportant(boolean important) {
        this.important = important;
    }

    public int getRandomId() {
        return randomId;
    }

    public void setRandomId(int randomId) {
        this.randomId = randomId;
    }

    public List<Object> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Object> attachments) {
        this.attachments = attachments;
    }

    public boolean isHidden() {
        return isHidden;
    }

    public void setHidden(boolean hidden) {
        this.isHidden = hidden;
    }
}
