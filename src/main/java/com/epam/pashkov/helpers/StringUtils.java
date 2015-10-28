package com.epam.pashkov.helpers;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * User: Yaroslav_Pashkov
 * Date: 27.10.2015
 * Time: 17:15
 */
public class StringUtils {
    public static double getPrice(String price) {
        String comp = "";
        Pattern pattern = Pattern.compile("(\\d)");
        Matcher matcher = pattern.matcher(price);
        while (matcher.find()) {
            comp += matcher.group();
        }
        return Double.parseDouble(comp);
    }

    public static int getCount(String count) {
        String comp = "";
        Pattern pattern = Pattern.compile("(\\d)");
        Matcher matcher = pattern.matcher(count);
        while (matcher.find()) {
            comp += matcher.group();
        }
        return Integer.parseInt(comp);
    }
}
