package socrates_sons_trading.beans;

import java.util.LinkedList;

public class Row implements Comparable<Row>{

    private LinkedList<Integer> integers = new LinkedList<>();

    private int sum = 0;

    public void addNumber(int number){
        sum += number;
        integers.add(number);
    }

    public Integer getMin(){
        int min = Integer.MAX_VALUE;

        for (int num: integers)
            if (num < min)
                min = num;

        return min;
    }

    public Integer getIndexOfMin(){
        return integers.indexOf(getMin());
    }

    public LinkedList<Integer> getIntegers() {
        return integers;
    }

    public void setIntegers(LinkedList<Integer> integers) {
        this.integers = integers;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    @Override
    public int compareTo(Row o) {
        if (this.sum > o.sum)
            return 1;
        else if (this.sum < o.sum)
            return -1;
        return 0;
    }
}
