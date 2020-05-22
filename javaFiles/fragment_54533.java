public static Callable<Integer[][]> getMultiplierCallable(final int[][] xs,
            final int[][] ys, final int length) {
        return new Callable<Integer[][]>() {
            public Integer[][] call() throws Exception {
                Integer[][] answer = new Integer[length][length];
                answer = multiplyArray(xs, ys, length);
                return answer;
            }
        };
    }

    public static void main(final String[] args) throws ExecutionException,
            InterruptedException {
        final int[][] xs = {{1, 2}, {3, 4}};
        final int[][] ys = {{1, 2}, {3, 4}};
        final Callable<Integer[][]> callable = getMultiplierCallable(xs, ys, 2);
        final ExecutorService service = Executors.newFixedThreadPool(2);
        final Future<Integer[][]> result = service.submit(callable);
        final Integer[][] intArray = result.get();
        for (final Integer[] element : intArray) {
            System.out.println(Arrays.toString(element));
        }
    }