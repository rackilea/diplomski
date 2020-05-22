import java.util.concurrent.TimeUnit;

/**
 * Simulates Sudoku solver. Demonstrates how to update GUI. The whole
 * implementation is constructed so GUI never freezes.
 */
class DummySudokuImplementation implements SudokuImplementation {

    public DummySudokuImplementation() {
    }

    public void goButtonPressed(Integer[][] leftSudokuValues, SudokuController resultAcceptor) {
        System.out.println("Long running computation simulation...");
        for (int i = 0; i < 50; i++) {
            resultAcceptor.setSudokuCompleted(false);
            resultAcceptor.setSudokuTime(String.valueOf(i * 50) + "ms");
            resultAcceptor.setSudokuResult(getRandomResult());
            waitSomeTime();
        }
        resultAcceptor.setSudokuResult(leftSudokuValues);
        resultAcceptor.setSudokuCompleted(true);
        waitSomeTime();
        System.out.println("Done!");
    }

    private void waitSomeTime() {
        try {
            TimeUnit.MILLISECONDS.sleep(50);
        } catch (InterruptedException ex) {
        }
    }

    private Integer[][] getRandomResult() {
        Integer[][] randomResult = new Integer[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                randomResult[i][j] = (int) (Math.random() * 9);
            }
        }
        return randomResult;
    }
}