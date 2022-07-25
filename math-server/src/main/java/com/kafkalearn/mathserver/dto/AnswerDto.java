package com.kafkalearn.mathserver.dto;

public class AnswerDto extends AbstractDto{
    private int sum;

    public int getSum() {
        return sum;
    }

    public AnswerDto(int sum) {
        this.sum = sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }
}
