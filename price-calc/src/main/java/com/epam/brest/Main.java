package com.epam.brest;

import com.epam.brest.files.CSVFileReader;
import com.epam.brest.files.FileReader;
import com.epam.brest.selector.PriceSelector;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        // Distance
        // Price per km
        // Weight
        // Price per kg
        // Result = d * pr1 + w * pr2

        FileReader distancePriceFileReader = new CSVFileReader();
        Map<Integer, BigDecimal> distancePriceMap =
                distancePriceFileReader.readData("price_distance.csv");

        Map<Integer, BigDecimal> weightPriceMap =
                distancePriceFileReader.readData("price_distance.csv");

        PriceSelector priceSelector = new PriceSelector();

        Double[] enteredValues = new Double[2];
        Scanner scanner = new Scanner(System.in);
        String inputValue;
        int i = 0;
        do {
            if (i == 0) {
                System.out.println("Please, enter distance: ");
            } else if (i == 1) {
                System.out.println("Please, enter weight: ");
            }
            inputValue = scanner.next();
            if (inputValue.equalsIgnoreCase("Q")) {
                break;
            } else if(isCorrectDoubleValue(inputValue)) {
                enteredValues[i] = Double.parseDouble(inputValue);
                    i++;
            } else {
                System.out.println("Incorrect value: " + inputValue);
            }

            BigDecimal price = priceSelector.selectPriceValue(distancePriceMap, new BigInteger(enteredValues[0].toString()));
            System.out.println("Price: " + price);


            if (i == 2) {
                Double result = enteredValues[0] * price.doubleValue();
                System.out.println("Result: " + result);
            }
        } while (i < 2);

    }

    private static boolean isCorrectDoubleValue(String value) {
        boolean checkResult;
        try {
            double enteredValue = Double.parseDouble(value);
            checkResult = enteredValue >= 0;
        } catch (NumberFormatException ex) {
            checkResult = false;

        }
        return checkResult;

    }


}