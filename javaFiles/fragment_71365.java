public class Main {

    private static int M, N;

    public static void main(String[] args) {
        M = 0; // min value
        N = 10; // max value
        noLoop(M); // begin the method
    }

    private static void noLoop(int currentNumber) {
        String resultMessage;

        if (currentNumber % 3 == 0) {
            resultMessage = currentNumber + " is divisible by 3.";
        } else {
            resultMessage = currentNumber + " is NOT divisible by 3.";
        }

        if (currentNumber % 5 == 0) {
            resultMessage = currentNumber + " is divisible by 5.";
        } else {
            resultMessage = currentNumber + " is NOT divisible by 5.";
        }

        if (currentNumber % 3 == 0 && currentNumber % 5 == 0) {
            resultMessage = currentNumber + " is divisible by BOTH 3 and 5.";
        }

        System.out.println(resultMessage);
        M++; // min value + 1
        if (M <= N) { // if min value == max value, STOP!
            noLoop(M);
        }
    }
}