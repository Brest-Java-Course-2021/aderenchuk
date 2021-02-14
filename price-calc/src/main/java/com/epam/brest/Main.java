package com.epam.brest;

import com.epam.brest.files.CSVFileReader;
import com.epam.brest.files.FileReader;
import com.epam.brest.model.ReadData;
import com.epam.brest.model.Status;
import com.epam.brest.model.StatusType;
import com.epam.brest.selector.PriceSelector;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        // Distance
        // Price per km
        // Weight
        // Price per kg
        // Result = d * pr1 + w * pr2

        Scanner scanner = new Scanner(System.in);
        Status currentStatus = new ReadData();
        while (currentStatus.getType() != StatusType.EXIT) {
            currentStatus = currentStatus.handle(scanner);
        }
    }


}