public static void main(String[] args) {
    double start = -1;
    double end = 1;
    Random random = new Random();

    for(int i=1; i<10; i++){
        double result = start + (random.nextDouble() * (end - start));

        System.out.println(result);
    }
}