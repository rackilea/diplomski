public class MyStack {
    private int[] values;
    private int numberOfValues;

    public MyStack() {
        values = new int[5];
        numberOfValues = 0;
    }

    public boolean isEmpty() {
        return numberOfValues == 0;
    }

    public int peek() {
        return values[numberOfValues - 1];
    }

    public void push(int value) {
        if (numberOfValues <= 5) {
            values[numberOfValues] = value;
            numberOfValues++;
        }
    }

    public void pop() {
        numberOfValues--;
    }

    @Override
    public String toString() {
        String str = "";
        for (int i = 0; i <= numberOfValues - 1; i++) {
            str += String.valueOf(values[i]) + " ";
        }
        // str += "]";

        return str;
    }

}