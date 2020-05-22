public class Test1 {

    static List<BigInteger> list = new LinkedList<>();
    static BigInteger TWO = new BigInteger("2");

    public static void main(String[] args) {
        createList();

        long sum = 0;

        //warm-up
        for (int i = 0; i < 100; i++) {
            sum += forLoop().longValue();
            sum += lambda().longValue();
            sum += parallelLambda().longValue();
        }

        {
            System.gc();
            long start = System.currentTimeMillis();
            for (int i = 0; i < 100; i++) sum += forLoop().longValue();
            long end = System.currentTimeMillis();
            System.out.println("Time taken using for loop:  " + (end - start) + " ms");
        }

        {
            System.gc();
            long start = System.currentTimeMillis();
            for (int i = 0; i < 100; i++) sum += lambda().longValue();
            long end = System.currentTimeMillis();
            System.out.println("Time taken using lambda:  " + (end - start) + " ms");
        }

        {
            System.gc();
            long start = System.currentTimeMillis();
            for (int i = 0; i < 100; i++) sum += parallelLambda().longValue();
            long end = System.currentTimeMillis();
            System.out.println("Time taken using parallelLambda:  " + (end - start) + " ms");
        }
    }

    private static void createList() {
        for (int i = 0; i < 100000; i++) {
            list.add(new BigInteger(String.valueOf(i)));
        }
    }

    private static BigInteger forLoop() {
        BigInteger sum = BigInteger.ZERO;

        for(BigInteger n : list) {
            if(n.mod(TWO).equals(BigInteger.ZERO))
                sum = sum.add(n);
        }
        return sum;
    }

    private static BigInteger lambda() {
        return list.stream().
                filter(n -> n.mod(TWO).equals(ZERO)).
                reduce(ZERO, BigInteger::add);
    }

    private static BigInteger parallelLambda() {
        return list.parallelStream().
                filter(n -> n.mod(TWO).equals(ZERO)).
                reduce(ZERO, BigInteger::add);
    }
}