package br.edu.ifpb;

import java.util.Stack;

public class User implements Observer {

    private String email;
    private Stack<Message> messages;
    private WhatsappGroup whatsappGroup;

    public User(String email, WhatsappGroup whatsappGroup) {
        this.email = email;
        this.whatsappGroup = whatsappGroup;
        messages = new Stack<>();
    }

    @Override
    public void update() {
        Message message = whatsappGroup.getMessages().peek();
        if (!message.getSender().equals(email)) {
            System.out.println(String.format("Mensagem recebida - %s", email));
            System.out.println(message);
        }
        messages.push(message);
    }

    @Override
    public String getNome() {
        return email;
    }
}
