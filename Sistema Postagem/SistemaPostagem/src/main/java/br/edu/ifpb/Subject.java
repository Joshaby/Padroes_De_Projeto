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

    public void add(Observer observer) {
        observerList.add(observer);
        System.out.println(String.format("Usuário %s adicionado!", observer.getNome()));
    }

    public void del(String email) throws UserException {
        Observer observer = searchObserver(email);
        observerList.remove(observer);
        System.out.println(String.format("Usuário %s removido!", observer.getNome()));
    }

    public Observer searchObserver(String email) throws UserException {
        Optional<Observer> optionalObserver = observerList.stream().filter(observer -> observer.getNome().equals(email)).findFirst();
        return optionalObserver.orElseThrow(() -> new UserException(email));
    }

    public abstract void notifyObservers();
}
