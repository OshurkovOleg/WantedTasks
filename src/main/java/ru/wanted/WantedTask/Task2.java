package ru.wanted.WantedTask;

import java.math.BigDecimal;

public class Task2 {
    private static final String[] ONES = {"", "один", "два", "три", "четыре", "пять", "шесть", "семь", "восемь", "девять"};
    private static final String[] TENS = {"", "десять", "двадцать", "тридцать", "сорок", "пятьдесят", "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
    private static final String[] TEENS = {"десять", "одиннадцать", "двенадцать", "тринадцать", "четырнадцать", "пятнадцать", "шестнадцать", "семнадцать", "восемнадцать", "девятнадцать"};
    private static final String[] THOUSANDS = {"", "тысяча", "миллион", "миллиард"};
    public static final String ZERO = "ноль";
    public static final String MAX_NUMBER_MESSAGE = "Стоимость не может превышать 99 999.99";
    public static final String MAX_NUMBER = "99999.99";
    public static final String NUMBER_CANNOT_MINUS = "Стоимость не может быть отрицательной";

    public static String getPriceInWords(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException(NUMBER_CANNOT_MINUS);
        }

        if (price.compareTo(new BigDecimal(MAX_NUMBER)) > 0) {
            throw new IllegalArgumentException(MAX_NUMBER_MESSAGE);
        }

        int priceInteger = price.intValue();
        int fractionalPart = (int) ((price.subtract(new BigDecimal(priceInteger)).multiply(new BigDecimal(100))).intValue());

        StringBuilder resultString = new StringBuilder();

        if (priceInteger == 0) {
            resultString.append(ZERO);
        } else {
            int thousands = 0;
            while (priceInteger > 0) {
                if (priceInteger % 1000 != 0) {
                    resultString.insert(0, convertDigits(priceInteger % 1000) + " " + THOUSANDS[thousands] + " ");
                }
                priceInteger /= 1000;
                thousands++;
            }
            resultString.deleteCharAt(resultString.length() - 1);
        }

        if (fractionalPart > 0) {
            resultString.append(convertDigits(fractionalPart));
        }

        return resultString.toString().trim();
    }

    private static String convertDigits(int number) {
        StringBuilder resultWords = new StringBuilder();

        int hundred = number / 100;
        int ten = (number / 10) % 10;
        int one = number % 10;

        if (hundred > 0) {
            resultWords.append(ONES[hundred]).append(" сто ");
        }

        if (ten == 1) {
            resultWords.append(TEENS[one]);
        } else {
            resultWords.append(TENS[ten]);
            if (one > 0) {
                resultWords.append(" ").append(ONES[one]);
            }
        }

        return resultWords.toString().trim();
    }

}
