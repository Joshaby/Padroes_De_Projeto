package br.edu.ifpb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public abstract class Subject {

    protected List<Observer> observerList;

    public Subject(Observer ...observers) {
        observerList = new ArrayList<>();
        observerList.addAll(Arrays.asList(observers));
    }
    public Subject() {
        observerList = new ArrayList<>();
    }

    public void add(Observer observer) throws UserException {
        Observer observer1 = searchObserver(observer.getNome());
        if (observer1 != null)
            throw new UserException(String.format("O usuário com o email %s já existe!", observer1.getNome()));
        observerList.add(observer);
        System.out.printf("Usuário %s adicionado!%n", observer.getNome());
        listObservers();
    }

    public void del(String email) throws UserException {
        Observer observer = searchObserver(email);
        if (observer == null)
            throw new UserException(String.format("O usuário com o email %s não existe no grupo!", email));
        observerList.remove(observer);
        System.out.printf("Usuário %s removido!%n", observer.getNome());
        listObservers();
    }

    public Observer searchObserver(String email) throws UserException {
        Optional<Observer> optionalObserver = observerList.stream().filter(observer -> observer.getNome().equals(email)).findFirst();
        // return optionalObserver.orElseThrow(() -> new UserException(String.format("O usuário com o email %s não existe!", email)));
        return optionalObserver.orElse(null);
    }

    private void listObservers() {
        System.out.println("Usuários disponíveis: ");
        observerList.forEach(observer -> {
            System.out.println(observer.getNome());
        });
    }

    public abstract void notifyObservers();
}
