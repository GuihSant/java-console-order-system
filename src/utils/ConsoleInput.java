package utils;

import java.util.Scanner;
import java.util.UUID;

public class ConsoleInput {

    private final Scanner sc;

    public ConsoleInput(Scanner sc) {
        this.sc = sc;
    }

    public int lerInt(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine();
            try {
                return Integer.parseInt(s);
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
    }

    public double lerDouble(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine();
            try {
                return Double.parseDouble(s.replace(",", "."));
            } catch (NumberFormatException e) {
                System.out.println("Digite um número válido (ex: 10.50).");
            }
        }
    }

    public UUID lerUUID(String msg) {
        while (true) {
            System.out.print(msg);
            String s = sc.nextLine();
            try {
                return UUID.fromString(s);
            } catch (IllegalArgumentException e) {
                System.out.println("UUID inválido. Cole um ID no formato correto.");
            }
        }
    }

    public String lerLinha(String msg) {
        System.out.print(msg);
        return sc.nextLine();
    }
}
