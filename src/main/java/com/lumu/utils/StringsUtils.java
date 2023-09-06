package com.lumu.utils;

import com.lumu.user_interfaces.WordCounterUI;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringsUtils {

    public static List<Integer> extractNumbersFromStrings(List<String> inputList) {
        List<Integer> numbersList = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\(\\s*(\\d+)\\s*%\\)");

        for (String input : inputList) {
            Matcher matcher = pattern.matcher(input);

            if (matcher.find()) {
                String numberStr = matcher.group(1);
                int number = Integer.parseInt(numberStr);
                numbersList.add(number);
            }
        }

        return numbersList;
    }
}
