package socrates_sons_trading;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        int length = scanner.nextInt();
        int[][] matrix = new int[length][length];
        int[] sumRows = new int[length];
        int[] solution = new int[length];

        for (int i = 0; i < length; i++) {
            int sum = 0;
            for (int j = 0; j < length; j++) {
                matrix[i][j] = scanner.nextInt();
                sum += matrix[i][j];
            }
            sumRows[i] = sum;
        }

        while (sumRows[getIndex(sumRows, Arrays.stream(sumRows).max().getAsInt())] != -1){
            int row = getIndex(sumRows, sumRows[getIndex(sumRows, Arrays.stream(sumRows).max().getAsInt())]);
            int column = getIndex(matrix[row], getMinValue(matrix[row]));

            solution[row] = column;
            sumRows[row] = -1;

            for (int i = 0; i < length; i++){
                matrix[i][column] = -1;
            }
        }


        //int minimum = getMinValue(matrix[getIndex(sumRows, sumRows[getIndex(sumRows, Arrays.stream(sumRows).max().getAsInt())])]);

        for (int num: solution)
            System.out.println(num);

    }
    static int getIndex(int[] arr, int key){
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == key)
                return i;
        return -1;
    }

    static int getMinValue(int[] arr){
        int value = Integer.MAX_VALUE;
        for (int num: arr)
            if (num < value && num != -1)
                value = num;

        return value;
    }
}
