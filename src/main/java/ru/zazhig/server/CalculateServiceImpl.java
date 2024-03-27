package ru.zazhig.server;

import org.springframework.stereotype.Service;
import ru.zazhig.dto.SalaryDto;
import ru.zazhig.model.AmountVacationPay;

import java.text.DecimalFormat;

@Service
public class CalculateServiceImpl implements CalculateService {
    private static final double ANDM = 29.3;  //среднее количество дней в месяце
    private static final String pattern = "#.##";

    @Override
    public AmountVacationPay paymentCalculation(SalaryDto salaryDto) {
        DecimalFormat rounding = new DecimalFormat(pattern);
        double totalAmount = salaryDto.getNumberDays() * (salaryDto.getAmount() / ANDM);
        String formattedNumber = rounding.format(totalAmount).replace(",", ".");
        return new AmountVacationPay(Double.parseDouble(formattedNumber));
    }
}
