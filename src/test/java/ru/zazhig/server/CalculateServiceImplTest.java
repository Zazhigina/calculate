package ru.zazhig.server;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.zazhig.dto.SalaryDto;

import static org.junit.jupiter.api.Assertions.*;
import static ru.zazhig.server.TestValidatorUtil.hasErrorMessage;

@ExtendWith(MockitoExtension.class)
class CalculateServiceImplTest {
    @InjectMocks
    private CalculateServiceImpl calculateService;

    @Test
    void paymentCalculation() {
        SalaryDto salaryDto = new SalaryDto(50000.0, 14);
        assertEquals(23890.78, calculateService.paymentCalculation(salaryDto).getAmount());
    }

    @Test
    public void exceptionSalaryServiceTest() {
        final SalaryDto salaryDto = SalaryDto.builder()
                .amount(-50000.0)
                .numberDays(14)
                .build();

        assertTrue(hasErrorMessage(salaryDto, "Значение {amount} не может быть меньше или равно 0"));
    }

    @Test
    public void exceptionDayServiceTest() {
        final SalaryDto salaryDto = SalaryDto.builder()
                .amount(50000.0)
                .numberDays(-14)
                .build();
        assertTrue(hasErrorMessage(salaryDto, "Значение {numberDays} не может быть меньше или равно 0"));
    }
}