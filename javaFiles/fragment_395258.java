class TestNano {

    public static void main(String[] args) throws Exception {
        long[] nano = new long[10000];

        for (int i = 0; i < nano.length; ++i) {
            nano[i] = System.nanoTime();
        }

        for (int i = 0; i < nano.length; ++i) {
            System.err.println("INDEX: " + i
                    + " NANO: " + nano[i]
                    + " TIME USED: " + (i == 0 ? 0 : (nano[i] - nano[i - 1])));
        }
    }
}