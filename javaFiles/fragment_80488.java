public static void main(String[] args) {
    double temp = 0;

    long start = System.nanoTime();

    for (int i = 0; i < 100; i++) {
        temp += Math.exp(0.0) / (1.0 + Math.exp(0.0));
    }

    System.out.println("AVERAGE: " + ((System.nanoTime() - start) / 100));
    System.out.println("temp: " + temp);
}