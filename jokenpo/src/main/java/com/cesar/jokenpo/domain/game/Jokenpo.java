package com.cesar.jokenpo.domain.game;

import com.cesar.jokenpo.domain.values.JokenpoValues;

/**
 * @author Cesar Schutz
 */
public interface Jokenpo {
    static int run(final JokenpoValues value1, final JokenpoValues value2) {
        if (value1 == value2) return 0;
        switch (value1) {
            case PEDRA:
                return (value2 == JokenpoValues.TESOURA ? 1 : -1);
            case PAPEL:
                return (value2 == JokenpoValues.PEDRA ? 1 : -1);
            case TESOURA:
                return (value2 == JokenpoValues.PAPEL ? 1 : -1);
        }
        return 0;
    }
}
