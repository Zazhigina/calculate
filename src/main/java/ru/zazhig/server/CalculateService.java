package ru.zazhig.server;

import ru.zazhig.dto.SalaryDto;
import ru.zazhig.model.AmountVacationPay;

public interface CalculateService {
    AmountVacationPay paymentCalculation(SalaryDto salaryDto);
}
