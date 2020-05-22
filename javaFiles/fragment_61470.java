long sum = threadPoolExecutor.invokeAll(callables)
            .stream()
            .mapToLong(future -> {
                try {
                    return future.get();
                } catch (Exception e) {
                    throw new IllegalStateException(e);
                }
            }) // LongStream
            .sum(); // sum of the stream