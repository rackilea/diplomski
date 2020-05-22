@ThreadSafe
public class NumberRange {

    @GuardedBy("this") private int lower, upper;

    public synchronized void setLower(int i) {
        if (i > upper) {
            throw new IllegalArgumentException("can't set lower to " + i + " > upper");
        }
        lower = i;
    }

    public synchronized void setUpper(int i) {
        if (i < lower) {
            throw new IllegalArgumentException("can't set upper to " + i + " < lower");
        }
        upper = i;
    }

    public synchronized boolean isInRange(int i) {
        return (i >= lower && i <= upper);
    }
}