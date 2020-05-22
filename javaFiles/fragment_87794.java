int size = 11;
int odd = (size % 2 == 0) ? 0 : 1;
int mid = (size / 2) - 1;
int[] output = IntStream.range(0, size - 1)
         .map(i -> (i > mid) ? mid + (mid - i) + odd : i).toArray();

IntStream.of(output).forEach(System.out::print);