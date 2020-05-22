java.util.function.BiConsumer<Integer, Integer> times = (i, num) -> {
    i *= num;
    System.out.println(i);
};
for (int i = 1; i < 100; i++) {
    times.accept(i, 2); //multiply i by 2 and print i
    times.accept(i, i); //square i and then print the result
}