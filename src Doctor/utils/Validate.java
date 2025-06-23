package utils;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validate {
    private Validate() {
    }

    static Scanner s = new Scanner(System.in);

    public static int getInt(String msg,
            String msg_out_range,
            String msg_invalid,
            double min, double max) {
        while (true) {
            try {
                System.out.print(msg);
                String input = s.nextLine();
                int number = Integer.parseInt(input);
                if (number > min && number <= max) {
                    return number;
                }
                System.out.println(msg_out_range);
            } catch (NumberFormatException e) {
                System.out.println(msg_invalid);
            }
        }
    }

    public static String getString(String msg, String msg_invalid, String regex) {
        Pattern p = Pattern.compile(regex);
        while (true) {
            System.out.print(msg);
            String input = s.nextLine();
            if (p.matcher(input).matches()) {
                return input;
            }
            System.out.println(msg_invalid);
        }

    }
}
