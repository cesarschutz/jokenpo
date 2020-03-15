package com.cesar.jokenpo.domain.game;

import com.cesar.jokenpo.domain.values.JokenpoValues;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class JokenpoTest {

    @Test
    @DisplayName("Jogador 1 escolhendo PEDRA")
    void runTestWIthPlayer1PEDRA() {
        assertEquals(0, Jokenpo.run(JokenpoValues.PEDRA, JokenpoValues.PEDRA));
        assertEquals(1, Jokenpo.run(JokenpoValues.from(0), JokenpoValues.TESOURA));
        assertEquals(-1, Jokenpo.run(JokenpoValues.PEDRA, JokenpoValues.PAPEL));
    }

    @Test
    @DisplayName("Jogador 1 escolhendo PAPEL")
    void runTestWIthPlayer1PAPEL() {
        assertEquals(0, Jokenpo.run(JokenpoValues.PAPEL, JokenpoValues.PAPEL));
        assertEquals(1, Jokenpo.run(JokenpoValues.from(1), JokenpoValues.PEDRA));
        assertEquals(-1, Jokenpo.run(JokenpoValues.PAPEL, JokenpoValues.TESOURA));
    }

    @Test
    @DisplayName("Jogador 1 escolhendo TESOURA")
    void runTestWIthPlayer1TESOURA() {
        assertEquals(0, Jokenpo.run(JokenpoValues.TESOURA, JokenpoValues.TESOURA));
        assertEquals(1, Jokenpo.run(JokenpoValues.from(2), JokenpoValues.PAPEL));
        assertEquals(-1, Jokenpo.run(JokenpoValues.TESOURA, JokenpoValues.PEDRA));
    }
}