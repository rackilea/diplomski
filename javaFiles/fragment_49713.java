public class AvgCalculator {
    private double avg = 0.0f;
    private int    cnt = 0;


    /**
     * Calculates a new average based on the current one and
     * a specified new value. After calling this method avg
     * holds the new average value;
     *
     * @return the new average
     */
    public double calcNewAvg(final int newValue) {
        return avg = ((avg * cnt) + newValue) / ++cnt;
    }

    /**
     * Resets the average and count to zero
     */
    public void resetAvg() {
        avg = 0.0f;
        cnt = 0;
    }

    public double getAvg() {
        return avg;
    }
}