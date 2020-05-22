class PERMUTATION {
    private int count = 1;

    public void perm(char[] arr, int k) {
        if (k == 3) {
            System.out.print(count++ + ".");
            for (int i = 0; i < 3; ++i)
                System.out.print(arr[i] + "  ");
            System.out.println();
            return;
        }
        char[] arr2 = arr.clone(); // clone the passed array, so we don't mess it up
        for (int i = k; i <= 3; ++i) {
            /* interchanging ith character with kth character */
            char c = arr2[k - 1];
            arr2[k - 1] = arr2[i - 1];
            arr2[i - 1] = c;
            perm(arr2, k + 1);
        }
    }

    public static void main(String[] args) {
        System.out.println("the permutations are");
        PERMUTATION obh = new PERMUTATION();
        obh.perm(new char[] {'A', 'B', 'C'}, 1); // pass the original array
    }
}