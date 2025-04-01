package com.test.atividade01;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite letras distintas (ex: abc): ");
        String input = scanner.nextLine();

        try {
            List<String> anagramas = AnagramGenerator.generateAnagrams(input);
            System.out.println("Anagramas gerados:");
            for (String a : anagramas) {
                System.out.println(a);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}
