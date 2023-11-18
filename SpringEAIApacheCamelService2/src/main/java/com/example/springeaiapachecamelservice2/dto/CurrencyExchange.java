package com.example.springeaiapachecamelservice2.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CurrencyExchange {
    Long id;
    String from;
    String to;
    BigDecimal conversionMultiple;
}
