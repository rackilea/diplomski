public class AlgorithmDriver {
    public static void main(String [] args) {
        int numTries = 1000000;
        long begTime = System.currentTimeMillis();
        for (int i = 0; i < numTries; ++i) {
            Algorithm.someMethodCall();
        }
        long endTime = System.currentTimeMillis();
        System.out.printf("Total time for %10d tries: %d ms\n", numTries, (endTime-begTime));
    }
}