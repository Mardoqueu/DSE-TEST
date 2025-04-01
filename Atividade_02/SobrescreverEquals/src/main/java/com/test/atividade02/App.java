package com.test.atividade02;

import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("João", "11111111111");
        Pessoa p2 = new Pessoa("Maria", "11111111111");
        Pessoa p3 = new Pessoa("Ana", "22222222222");

        Set<Pessoa> pessoas = new HashSet<>();
        pessoas.add(p1);
        pessoas.add(p2);
        pessoas.add(p3);

        System.out.println("Pessoas no conjunto:");
        for (Pessoa p : pessoas) {
            System.out.println(p);
        }
    }
}
