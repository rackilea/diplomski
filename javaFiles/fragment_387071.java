public static void main(String args[]) {
    int[] array = new int[] {1, 2, 3, 4};
    int n = array.length;
    int k = 3;

    ArrayList<int[]> splits = getSplits(n, k);

    for (int[] split : splits) {
        int j = 0;
        for (int i = 0; i < split.length; i++) {
            for (; j < split[i]; j++) {
                System.out.print(array[j] + " ");
            }
            System.out.print("| ");
        }
        for (; j < n; j++) {
            System.out.print(array[j] + " ");
        }
        System.out.println();
    }
}