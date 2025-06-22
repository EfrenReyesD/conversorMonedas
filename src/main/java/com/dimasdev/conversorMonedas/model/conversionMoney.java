package com.dimasdev.conversorMonedas.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)

public record conversionMoney(
        @JsonAlias("conversion_result") int resultadoConversion
) {

}
