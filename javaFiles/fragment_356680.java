private static int[] getListOfOperator(int[][] numberLists, Function<int[],Integer> operator) {
    int[] products = new int[3];
    for (int i = 0; i < 3; i++) {
        products[i] = operator.apply(numberLists[i]);
    }
    return products;
}