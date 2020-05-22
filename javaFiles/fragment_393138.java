ExecutorService executor = Executors.newFixedThreadPool(5);

for(int num : numbers) {
    Integer x = num;
    for(int num2 : otherNumbers) {
        Integer y = num2;
        executor.execute(() -> System.out.println(x+y));
    }
}