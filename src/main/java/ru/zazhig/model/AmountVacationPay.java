package ru.zazhig.model;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class AmountVacationPay {
    private double amount;

    @Override
    public String toString() {
        return "AmountVacationPay{" +
                "amount=" + amount +
                '}';
    }
}