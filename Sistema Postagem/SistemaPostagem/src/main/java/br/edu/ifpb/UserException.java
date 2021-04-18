package br.edu.ifpb;

public class UserException extends Exception {
    public UserException(String email) {
        super(String.format("O usuário com o email %s não existe!", email));
    }
}
