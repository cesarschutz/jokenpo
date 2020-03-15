package com.cesar.jokenpo.domain.values;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Random;

/**
 * @author Cesar Schutz
 */
public enum JokenpoValues {
    PEDRA(0),
    PAPEL(1),
    TESOURA(2);

    private Integer code;

    JokenpoValues(final Integer code) {
        this.code = code;
        Mapping.CODE_MAPPING.put(code, this);
    }

    public static JokenpoValues from(final Integer code) {
        final Optional<JokenpoValues> value = Optional.ofNullable(Mapping.CODE_MAPPING.get(code));
        if (value.isEmpty()) {
            throw new IllegalStateException(String.format("The code '%s' is not supported.", code));
        }
        return value.get();
    }

    public static JokenpoValues randomJokenpoValues() {
        return Mapping.CODE_MAPPING.get(new Random().nextInt(Mapping.CODE_MAPPING.size()));
    }

    private static class Mapping {
        static Map<Integer, JokenpoValues> CODE_MAPPING = new HashMap<>(3);
    }
}
