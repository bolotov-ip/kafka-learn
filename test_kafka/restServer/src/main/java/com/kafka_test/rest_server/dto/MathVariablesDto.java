package com.kafka_test.rest_server.dto;

import java.util.Objects;

public class MathVariablesDto {
    private int x;
    private int y;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MathVariablesDto)) return false;

        MathVariablesDto that = (MathVariablesDto) o;

        if (x != that.x) return false;
        return y == that.y;
    }

    @Override
    public int hashCode() {
        int result = x;
        result = 31 * result + y;
        return result;
    }
}
