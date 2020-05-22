public static void main(String[] args) {
    int[] source = {0,8,2,3,1,9,5,6,4,7};
    int k = 3, n = 10;
    int[] destination = new int[k];

    // first the sorting
    Arrays.sort(source);


    for (int i = 0; i < n; i++)
        System.out.print(source[i] + " ");
    System.out.println();

    if (k > 0)
        loopy_loop(source, destination, 0, 0);

}