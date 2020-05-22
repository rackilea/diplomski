long start = System.currentTimeMillis();
    Map<Integer, Long> freq = IntStream.range(0,1000000000)/*.parralel()*/
            .mapToObj(i -> i % 10)
            .collect(Collectors.groupingBy/*Concurrent*/(w -> w, Collectors.counting()));
    long time = System.currentTimeMillis() - start;
    System.out.println("Took " + time+" ms " + freq);

without parallel(), with groupingBy : Took 14156 ms {0=100000000, 1=100000000, 2=100000000, 3=100000000, 4=100000000, 5=100000000, 6=100000000, 7=100000000, 8=100000000, 9=100000000}
with parallel(), with groupingBy : Took 5581 ms {0=100000000, 1=100000000, 2=100000000, 3=100000000, 4=100000000, 5=100000000, 6=100000000, 7=100000000, 8=100000000, 9=100000000}
without parallel(), with groupingByConcurrent : Took 38218 ms {0=100000000, 1=100000000, 2=100000000, 3=100000000, 4=100000000, 5=100000000, 6=100000000, 7=100000000, 8=100000000, 9=100000000}
with parallel(), with groupingByConcurrent : Took 27619 ms {0=100000000, 1=100000000, 2=100000000, 3=100000000, 4=100000000, 5=100000000, 6=100000000, 7=100000000, 8=100000000, 9=100000000}