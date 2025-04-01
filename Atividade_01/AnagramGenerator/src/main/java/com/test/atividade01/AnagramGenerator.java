package com.test.atividade01;

import java.util.ArrayList;
import java.util.List;

public class AnagramGenerator {

    public static List<String> generateAnagrams(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("A entrada não pode ser nula ou vazia.");
        }

        if (!input.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("A entrada deve conter apenas letras (a-z ou A-Z).");
        }

        List<String> result = new ArrayList<>();
        backtrack("", input, result);
        return result;
    }

    private static void backtrack(String prefix, String remaining, List<String> result) {
        if (remaining.isEmpty()) {
            result.add(prefix);
        } else {
            for (int i = 0; i < remaining.length(); i++) {
                String newPrefix = prefix + remaining.charAt(i);
                String newRemaining = remaining.substring(0, i) + remaining.substring(i + 1);
                backtrack(newPrefix, newRemaining, result);
            }
        }
    }
}
