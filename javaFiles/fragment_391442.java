static Stream<int[]> build() {
    return IntStream.rangeClosed(240, 1280).boxed()
               .flatMap(w -> IntStream.rangeClosed(1, 10).map(m -> 2 * m).boxed()
                   .flatMap(m -> IntStream.rangeClosed(2, 100).boxed()
                       .flatMap(n -> IntStream.rangeClosed(240, 1280)
                                              .filter(g -> ((w - 2*m - n*g) % (n+1) == 0))
                                              .filter(g -> n*g+2*m <= w)
                                              .filter(g -> n*g <= w)
                                              .mapToObj(g -> new int[] { w, m, n, g }))));
}