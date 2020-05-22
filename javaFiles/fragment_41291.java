public static void main(String[] args) {
    int[][] m1 = { { 14, 11, 13, 12 }, { 18, 15, 13, 13 },
            { 19, 16, 15, 17 } };
    int[][] temp = new int[m1.length][]; // <-- a new array for the copies.
    for (int i = 0; i < m1.length; i++) {
        temp[i] = m1[i].clone();         // <-- copy each row.
        Arrays.sort(temp[i]);            // <-- sort each row.
    }
    System.out.println("Original: " + Arrays.deepToString(m1));
    System.out.println("Sorted copy: " + Arrays.deepToString(temp));
}