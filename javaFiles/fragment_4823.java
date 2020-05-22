public class StackOverflow {
    public static void main(String[] args) {
        int a = 0;
        int rowColLength = 3;
        int numberOfDigits = rowColLength * 2 - 1;

        for (int i = 0; i < numberOfDigits; i++) {
            if (i < rowColLength) {
                // Prints the first row
                System.out.print(++a + " ");
            } else if (i == rowColLength){
                // Decrements the last number from the first row 
                // to continue the column count for printing
                System.out.print("\r\n" + --a);
            } else {
                // Prints the rest of the column
                System.out.print("\r\n" + ++a);
            }
        }
    }
}