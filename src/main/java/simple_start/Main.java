package simple_start;

import java.util.Locale;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int B = scanner.nextInt();
        IntStream.rangeClosed(1, 300).filter(i -> {
            return isSymmetryText(baseConversion(String.valueOf(i*i), 10, B));
        }).forEach(i ->{
            String number = baseConversion(String.valueOf(i), 10, B);
            String base = baseConversion(String.valueOf(i * i), 10, B);

            System.out.println(number + " " + base);
        });

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
