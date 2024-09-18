package ru.wanted.WantedTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Date;

import static ru.wanted.WantedTask.Task2.getPriceInWords;


@SpringBootApplication
public class WantedTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(WantedTaskApplication.class, args);

		Date currentDate = new Date(System.currentTimeMillis());
		Date nextSubmissionDate = new Task1().getNearestShippingDate(currentDate);
		System.out.println("Ближайшая дата: " + nextSubmissionDate);

        BigDecimal amount = new BigDecimal("123.32");
        System.out.println(getPriceInWords(amount));
    }

}
