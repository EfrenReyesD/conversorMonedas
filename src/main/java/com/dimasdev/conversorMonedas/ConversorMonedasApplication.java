package com.dimasdev.conversorMonedas;

import com.dimasdev.conversorMonedas.principal.principal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConversorMonedasApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ConversorMonedasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		principal principal = new principal();
		principal.menuDeConversion();
	}
}
