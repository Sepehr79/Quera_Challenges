package simple_start;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int B = scanner.nextInt();
        for (int i = 1; i <= 300 ; i++){
            int power = i * i;

            String number = baseConversion(String.valueOf(i), 10, B);
            String baseNumber = baseConversion(String.valueOf(power), 10, B);

            if (isSymmetryText(baseNumber))
                System.out.println(number + " " + baseNumber);
        }

    }

    public static String baseConversion(String number, int sBase, int dBase) {
        // Parse the number with source radix
        // and return in specified radix(base)
        return Integer.toString(
                Integer.parseInt(number, sBase),
                dBase).toUpperCase(Locale.ROOT);
    }

    public static boolean isSymmetryText(String text){
        StringBuilder builder = new StringBuilder(text);
        return builder.toString().equals(builder.reverse().toString());
    }

}
