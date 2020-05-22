public static void main(String[] args) {
    int[] thirteenMultiples = new int[400];
    for (int dex = 0; dex < thirteenMultiples.length; dex ++) {
        int multiples = 13 * dex; 
        thirteenMultiples[dex] = multiples;
        System.out.println(Arrays.toString(thirteenMultiples));
    }
}