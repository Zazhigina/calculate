package ru.zazhig.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SalaryDto {
    @Positive(message = "Значение {amount} не может быть меньше или равно 0")
    @NotNull(message = "Значение {amount} не может быть пустое")
    private Double amount;
    @NotNull(message = "Значение {numberDays} не может быть пустое")
    @Positive(message = "Значение {numberDays} не может быть меньше или равно 0")
    private Integer numberDays;
}
   /* @NotNull(message = "Start Date cannot be null.")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;*/