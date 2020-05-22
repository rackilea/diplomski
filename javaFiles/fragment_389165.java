public class Permutation {

    private static final int NB_DIGITS = 10;

    private int[] DIGIT_NUMBER = {1,10,100,1000,10000,100000,1000000,10000000,100000000, 1000000000};

    public void dump(PrintStream printStream) {
        int[] counter = new int[NB_DIGITS];
        Arrays.fill(counter, 0);
        do {
            int column1 = 0;
            int column2 = 0;
            int column3 = 0;

            for (int i = 0; i < NB_DIGITS; i++) {
                int columnIdx = counter[i];
                switch (columnIdx) {
                    case 0 : column1+=DIGIT_NUMBER[i];break;
                    case 1 : column2+=DIGIT_NUMBER[i];break;
                    case 2 : column3+=DIGIT_NUMBER[i];break;
                    default:
                        assert false;
                }

            }

            printStream.format("%d;%d;%d%n", column1, column2, column3);

        } while (increase(counter));
    }

    public boolean increase(int[] counter) {
        int idx = 0;
        while (idx < counter.length && counter[idx] == 2) {
            counter[idx] = 0;
            idx++;
        }

        if (idx == counter.length) {
            return false;
        }

        counter[idx]++;
        return true;
    }

    public static void main(String[] args) {
        new Permutation().dump(System.out);
    }
}