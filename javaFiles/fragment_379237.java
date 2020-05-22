public class NumberDisplay {

    private int minimum = 1;
    private int maximum = 13;
    private int value;

    /**
     * Constructor for objects of class NumberDisplay. Set the limit at
     * which the display rolls over.
     */
    public NumberDisplay(int maxumum, int minimum) {
        this.maximum = maxumum;
        this.minimum = minimum;
        value = 1;
    }

    //...

    /**
     * Set the value of the display to the new specified value. If the new
     * value is less than zero or over the limit, do nothing.
     */
    public boolean setValue(int replacementValue) {
        if (replacementValue >= maximum) {
            value = minimum;
            return true;
        } else {
            value = replacementValue;
            return false;
        }
    }

    /**
     * Increment the display value by one, rolling over to zero if the limit
     * is reached.
     */
    public boolean increment() {