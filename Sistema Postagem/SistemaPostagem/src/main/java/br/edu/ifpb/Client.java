package br.edu.ifpb;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final Pattern pattern = Pattern.compile(EMAIL_PATTERN, Pattern.CASE_INSENSITIVE);

    public static boolean emailValidator(String email) {
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static String generateMessage(String[] array) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 2; i < array.length; i ++) {
            if (i != array.length - 1) stringBuilder.append(array[i]).append(" ");
            else stringBuilder.append(array[i]);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        WhatsappGroup whatsappGroup = new WhatsappGroup();
        Scanner input = new Scanner(System.in);
        while (true) {
            try {
                System.out.print(ANSI_GREEN + "$> " + ANSI_RESET);
                String command = input.nextLine();
                String[] subcommands = command.split(" ");
                if (!subcommands[0].equals("postagem"))
                    System.out.println(ANSI_RED + "Comando principal errado! Siga a sinópse: postagem {add email | del email | email \"message\"}" + ANSI_RESET);
                else if (subcommands.length == 1)
                    System.out.println(ANSI_RED + "Comando está incompletp! Siga a sinópse: postagem {add email | del email | email \"message\"}" + ANSI_RESET);
                else {
                    if (subcommands[1].equals("add")) {
                        if (emailValidator(subcommands[2])) whatsappGroup.add(new User(subcommands[2], whatsappGroup));
                        else System.out.println(ANSI_RED + "Email inválido!" + ANSI_RESET);
                    }
                    else if (subcommands[1].equals("del")) {
                        if (emailValidator(subcommands[2])) whatsappGroup.del(subcommands[2]);
                        else System.out.println(ANSI_RED + "Email inválido!" + ANSI_RESET);
                    }
                    else if (!subcommands[1].equals("add") && !subcommands[1].equals("del") && emailValidator(subcommands[1]))
                        if (subcommands.length <= 2) System.out.println(ANSI_RED + "Digite uma mensagem!" + ANSI_RESET);
                        else whatsappGroup.addMessage(subcommands[1], generateMessage(subcommands));
                    else System.out.println(ANSI_RED + "Email inválido ou opções inválidas digitadas!\n As opções disponíveis são add email | del email | \"email\" \"message\"" + ANSI_RESET);
                }
            }
            catch (UserException e) {
                System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
            }
        }
    }
}
