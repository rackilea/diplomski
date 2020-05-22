public static void main(String[] args) {
    long start, end, average;
    double temp = 0;

    // start = System.nanoTime();

    average = 0L;
    for (int i = 0; i < 100; i++) {
        start = System.nanoTime();
        temp += Math.exp(0.0) / (1.0 + Math.exp(0.0));
        end = System.nanoTime();

        average += (end - start);
        // System.out.println(i + " " + (end - start));
    }
    System.out.println("AVERAGE: " + (average / 100));
    System.out.println("temp: " + temp);
}