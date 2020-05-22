public class ComboLock {

    private static final int MAX_NUMBERS = 40;

    private int currentNumber = 0; // current value lock dial is set to
    private int combination[] = null; // holds the combination to the lock
    private int currentPosition = 0; // current position of the combination array used for comparison

    // Allow for a lock that can handle more than size 3
    public ComboLock(int ... combination) {
        this.combination = combination;
    }

    /**
     * Resets the state of the lock so that it can be opened again.
     */
    public void reset() {
        currentPosition = 0;
    }

    public void turnLeft(int ticks) {
        currentNumber = (currentNumber + ticks) % MAX_NUMBERS;
        // Only compare the number when turning left the current position is odd
        if (currentPosition%2 == 1 && combination[currentPosition] == currentNumber) {
            currentPosition = Math.min(currentPosition + 1, combination.length - 1);
        }
    }

    public void turnRight(int ticks) {
        currentNumber = (currentNumber + (MAX_NUMBERS - ticks % MAX_NUMBERS)) % MAX_NUMBERS;
        // Only compare the number when turning right and the current position is even
        if (currentPosition%2 == 0 && combination[currentPosition] == currentNumber) {
            currentPosition = Math.min(currentPosition + 1, combination.length - 1);
        }
    }

    public boolean open() {
        return combination[currentPosition] == combination[combination.length - 1];
    }

    public int getCurrentNumber() {
        return currentNumber;
    }

    public static void main(String[] args) {
        ComboLock combo = new ComboLock(39, 25, 35);
        combo.turnRight(1);
        combo.turnLeft(26);
        combo.turnRight(30);
        assert combo.open();
        combo = new ComboLock(39, 25, 35);
        combo.turnLeft(39);
        combo.turnRight(14);
        combo.turnLeft(40);
        assert !combo.open();
    }
}