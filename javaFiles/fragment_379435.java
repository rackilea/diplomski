import java.io.IOException;

public class ThreadSleeper {
    public static final int TIMEOUT = 500;
    public static final int ROWS = 3, COLS = 4;
    static int[][] test = new int[ROWS][COLS];

    public static void main(String[] args) {
        // Populate values.
        for (int i = 0; i < ROWS * COLS; i++) {
            test[i / COLS][i % COLS] = i % COLS;
        }
        try {
            printColumns();
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }

    public static void printColumns() throws InterruptedException, IOException {
        for (int counter = 0; counter < COLS; counter++) {
            clearConsole(); // Clearing previous text.
            System.out.printf("Iteration #%d%n", counter + 1);
            for (int row = 0; row < ROWS; row++) {
                for (int col = 0; col <= counter; col++) {
                    System.out.print(test[row][col] + "...");
                }
                System.out.println();
            }
            Thread.sleep(TIMEOUT);
        }
    }

    // http://stackoverflow.com/a/33379766/1762224
    protected static void clearConsole() throws IOException, InterruptedException {
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
    }
}