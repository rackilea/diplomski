final int[] ints = IntStream.range(0, 6)
    .parallel()
    .map(i -> {
        System.out.println("thread " + Thread.currentThread().getName() + " maps " + i + " to " + i * i);
        return i * i;
    })
    .toArray();

System.out.println("Final array " + Arrays.toString(ints));