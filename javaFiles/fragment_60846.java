public static void main(String[] args) {
    double[][] m1 = { { 4, 8 }, { 0, 2 }, { 1, 6 } };
    double[][] m2 = { { 5, 2 }, { 9, 4 } };

    double[][] result = Arrays.stream(m1).map(r -> 
        IntStream.range(0, m2[0].length).mapToDouble(i -> 
            IntStream.range(0, m2.length).mapToDouble(j -> r[j] * m2[j][i]).sum()
    ).toArray()).toArray(double[][]::new);

    System.out.println(Arrays.deepToString(result));
}