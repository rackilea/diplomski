@Test
public void usingCallable() throws InterruptedException, ExecutionException {
    Collection<Integer> values = ints();

    Collection<Callable<Double>> callables = new ArrayList<>();
    callables.add(new Averager<>(values));
    callables.add(new Medianer<>(values));

    List<Double> res = concurrently(callables);
    System.out.println(res);
}