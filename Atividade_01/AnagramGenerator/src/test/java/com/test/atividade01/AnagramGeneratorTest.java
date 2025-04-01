package com.test.atividade01;

import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnagramGeneratorTest {

    @Test
    void deveGerarTodosAnagramasParaTresLetras() {
        List<String> result = AnagramGenerator.generateAnagrams("abc");
        assertEquals(6, result.size(), "Deve gerar 6 anagramas para 3 letras.");
        assertTrue(result.contains("abc"));
        assertTrue(result.contains("cba"));
    }

    @Test
    void deveGerarAnagramaUnicoParaUmaLetra() {
        List<String> result = AnagramGenerator.generateAnagrams("x");
        assertEquals(1, result.size());
        assertEquals("x", result.get(0));
    }

    @Test
    void deveLancarExcecaoParaEntradaVazia() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                AnagramGenerator.generateAnagrams(""));
        assertEquals("A entrada não pode ser nula ou vazia.", exception.getMessage());
    }

    @Test
    void deveLancarExcecaoParaEntradaComCaracteresInvalidos() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                AnagramGenerator.generateAnagrams("a1b"));
        assertEquals("A entrada deve conter apenas letras (a-z ou A-Z).", exception.getMessage());
    }
}
