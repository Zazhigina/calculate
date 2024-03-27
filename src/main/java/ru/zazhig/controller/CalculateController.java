package ru.zazhig.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ru.zazhig.dto.SalaryDto;
import ru.zazhig.model.AmountVacationPay;
import ru.zazhig.server.CalculateService;

import javax.validation.Valid;

@RestController
@RequestMapping("/calculate")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Slf4j
@Validated
public class CalculateController {
    private final CalculateService calculateService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public AmountVacationPay calculateVacation(@RequestBody @Valid SalaryDto salaryDto) {
        log.info("Запрос на сумму отпускных, которые придут сотруднику.");
        return calculateService.paymentCalculation(salaryDto);
    }

}
