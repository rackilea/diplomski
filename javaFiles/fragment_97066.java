import java.text.DecimalFormat;

public class Test3 {
    public static void main(String[] args) {
        final BoundedCounter minutes = new BoundedCounter(59, 0);
        final BoundedCounter hours = new BoundedCounter(23, 0);

        minutes.setOverflow(hours::next);
        hours.setOverflow(minutes::reset);

        for (int i = 0; i < 70; i++) { //repeats actual time 70 times - just to check if works fine
            minutes.next();
            System.out.println(hours.toString() + ":" + minutes.toString());
        }
    }

    public static class BoundedCounter {
        private int startValue;
        private int upperLimit;
        private int value;
        private Runnable c;

        public BoundedCounter(int upperLimit, int startValue) {
            this.upperLimit = upperLimit;
            this.startValue = startValue;
            this.value = startValue;
        }

        public void reset() {
            this.value = startValue;
        }

        public void setOverflow(final Runnable c) {
            this.c = c;
        }

        public void next() {
            if (++value > upperLimit) {
                value = 0;
                c.run();
            }
        }

        public String toString() {
            DecimalFormat df = new DecimalFormat("#00");
            return "" + df.format(value);
        }
    }
}