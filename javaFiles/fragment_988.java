public static void main(String[] args) {
    IntStream seq = IntStream.of(1, 2, 3, -1, -1, 1, 2, 1, 2);
    IntUnaryOperator next = i -> i + 1;

    List<List<Integer>> result = 
        IntStreamEx.of(seq).boxed().groupRuns((i1, i2) -> next.applyAsInt(i1) == i2).toList();

    System.out.println(result); // prints "[[1, 2, 3], [-1], [-1], [1, 2], [1, 2]]"
}