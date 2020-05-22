public class divisibleBy5and6 {
    public static void main (String[] args) {

        j = 1; 
        int number = 100;
        while (number < 1001) {
            if (number % 6 == 0 || number % 5 == 0) {
                System.out.print(number + ", ");
                number++;
                j++;
            }

            if (j % 10 == 0 && j != 0) {
                System.out.println();
                j++;
            }
            else {
                number++;
            }
        }