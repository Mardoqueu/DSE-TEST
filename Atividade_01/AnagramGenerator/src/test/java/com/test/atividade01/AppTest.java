package com.test.atividade01;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AppTest {

    private final InputStream originalIn = System.in;
    private final PrintStream originalOut = System.out;

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    @BeforeEach
    void setUpStreams() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @AfterEach
    void restoreStreams() {
        System.setIn(originalIn);
        System.setOut(originalOut);
    }

    private void provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
    }

    @Test
    void testEntradaValidaAbc() {
        provideInput("abc\n");
        App.main(new String[]{});

        String output = testOut.toString();
        assertTrue(output.contains("Anagramas gerados"));
        assertTrue(output.contains("abc"));
        assertTrue(output.contains("acb"));
        assertTrue(output.contains("bca"));
    }

    @Test
    void testEntradaInvalidaComNumero() {
        provideInput("a1b\n");
        App.main(new String[]{});

        String output = testOut.toString();
        assertTrue(output.contains("Erro: A entrada deve conter apenas letras (a-z ou A-Z)."));
    }

    @Test
    void testEntradaVazia() {
        provideInput("\n");
        App.main(new String[]{});

        String output = testOut.toString();
        assertTrue(output.contains("Erro: A entrada não pode ser nula ou vazia."));
    }
}
