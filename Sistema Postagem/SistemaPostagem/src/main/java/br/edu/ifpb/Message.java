package br.edu.ifpb;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Message {

    private String sender;
    private String text;
    private Date date;

    public Message(String sender, String text) {
        this.sender = sender;
        this.text = text;
        this.date = new Date(System.currentTimeMillis());
    }

    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm");
        return String.format("%s - %s - %s\n", sender, text, simpleDateFormat.format(date));
    }
}
