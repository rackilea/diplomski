LongStream.rangeClosed(minCandidate, n)
        .mapToObj(new LongFunction<long[]>() {
            @Override
            public long[] apply(long a) {
                return new long[]{a, calculateB(a, sum)};
            }
        })
        .filter(new Predicate<long[]>() {
            @Override
            public boolean test(long[] longs) {
                return longs[0] > longs[1] && 
                        longs[1] <= n && 
                        longs[0] * longs[1] == sum - longs[0] - longs[1];
            }
        })
        .forEach(new Consumer<long[]>() {
            @Override
            public void accept(long[] longs) {
                addArrays(list, longs);
            }
        });