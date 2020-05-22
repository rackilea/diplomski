public class Prog122h {
    public static void main(String[] args) {
        System.out.format("%-10s%-10s%-10s%-10s%-10s", "Number", "Square", "Square", "Root Cube", "4th Root"); // heading

        for (int number = 1; number <= 20; number++) // repeats finding the square and square root of the number until 40. increments number by 1
        {
            // finds square using math class
            int square = (int) Math.pow(number, 2);

            // finds square root of the number using math class
            double squareRoot = (Math.sqrt(number));

            squareRoot = Math.round(squareRoot * 10000.0) / 10000.0;

            // finds the cube of the number
            int cube = (int) Math.pow(number, 3);

            // finds the 4th root of the number
            double fourthRoot = Math.pow(number, 1.0 / 4);
            fourthRoot = Math.round(fourthRoot * 10000.0) / 10000.0;

            // output of table
            System.out.format("\n%-10s%-10s%-10s%-10s%-10s", number, square, squareRoot, cube, fourthRoot, fourthRoot);

        }
    }
}