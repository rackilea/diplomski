int [] a = new int [] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

// filter out all indices that evenly divide 3
int [] sliceArr = IntStream.range(0, a.length).filter(i -> i % 3 == 0)
    .map(i -> a[i]).toArray();

System.out.println(Arrays.toString(sliceArr));