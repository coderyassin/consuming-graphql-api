package com.example.demo;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String[] strings = {"yassin ", "mellouki"};
        String delimiter = "";
        String s = Arrays.stream(strings)
                .map(row -> String.join(delimiter, row))
                .collect(Collectors.joining("\n"));
        System.out.println(s);
    }

    public static String convertTableToString(String[][] table, String delimiter) {
        return Arrays.stream(table)
                .map(row -> String.join(delimiter, row))
                .collect(Collectors.joining("\n"));
    }
}
