package br.edu.ifpb;

import java.util.*;

public class WhatsappGroup extends Subject {

    private Stack<Message> messagesStack;

    public WhatsappGroup(Observer ...observers) {
        super(observers);
        messagesStack = new Stack<>();
    }
    public WhatsappGroup() {
        messagesStack = new Stack<>();
    }

    public Stack<Message> getMessages() {
        return messagesStack;
    }
    public void addMessage(String email, String message) throws UserException {
        searchObserver(email);
        messagesStack.push(new Message(email, message));
        notifyObservers();
    }

    @Override
    public void notifyObservers() {
        observerList.forEach(Observer::update);
    }
}
