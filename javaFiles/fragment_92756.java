Callable<Integer> c1 = () -> 1;
Callable<Integer> c2 = () -> {
        throw new RuntimeException();
};

List<Future<Integer>> futures = executor.invokeAll(Arrays.asList(c1,c2));
for (Future<Integer> future : futures) {
  System.out.println(future.get());
}