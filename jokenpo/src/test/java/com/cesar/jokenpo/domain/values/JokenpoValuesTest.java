package com.cesar.jokenpo.domain.values;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class JokenpoValuesTest {

    @Test()
    @DisplayName("Gerar um valor aleatório do Jokenpo (PEDRA, PAPEL ou TESOURA)")
    void randomJokenpoValuesTest() {
        assertNotNull(JokenpoValues.randomJokenpoValues());
    }

    @Test()
    @DisplayName("Obter um valor do Jokenpo através do seu código")
    void fromTest() {
        assertEquals(JokenpoValues.PEDRA, JokenpoValues.from(0));
        assertEquals(JokenpoValues.PAPEL, JokenpoValues.from(1));
        assertEquals(JokenpoValues.TESOURA, JokenpoValues.from(2));
    }

    @Test
    @DisplayName("Obter um valor do Jokenpo através de um código inválido")
    void fromWithErrorTest() {
        final Exception exception = assertThrows(Exception.class, () -> {
            JokenpoValues.from(3);
        });

        assertTrue(exception.getMessage().equals("The code '3' is not supported."));
    }
}