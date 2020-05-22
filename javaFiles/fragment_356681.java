public static void main(String[] args) {
    int[][] numberLists = new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    int[] sums = getListOfOperator(numberLists,Foo::add);
    int[] products = getListOfOperator(numberLists,Foo::multiply);
    print(sums);
    System.out.println("----");
    print(products);
}