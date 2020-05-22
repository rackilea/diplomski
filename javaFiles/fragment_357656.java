public static void main(String[] args)  {
    String value = "MAIN";
    System.out.printf("Main Thread: %s\n", value);

    IntStream.range(0,8).boxed().parallel().forEach(n -> {
        System.out.printf("Parallel Consumer - %d: %s\n", n, value);
    });
}