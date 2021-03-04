package balanced_sequence;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String line = scanner.nextLine();
        System.out.println(calculateAns(line));

    }
    static int calculateAns(String line){
        int balance = 0;
        int maxNegative = 0;

        for (char character: line.toCharArray()){
            if (character == '(')
                balance++;
            else if (character == ')')
                balance--;

            if (balance < 0 && Math.abs(balance) > maxNegative)
                maxNegative = (Math.abs(balance) % 2 == 0)? Math.abs(balance): Math.abs(balance)+1;
        }
        return balance / 2 + maxNegative;
    }
}
