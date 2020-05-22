public static void main(String[] args) {
       int[][] a = {
                {1,   2,  3,  4},
                {0,   1,  2,  3},
                {-1,  0,  1,  2},
                {-2, -1,  0,  1},
        };
        for (int j = 0; j <= a.length + a.length - 2; j++) {
            for (int k = 0; k <= j; k++) { // cols
                int l = j - k; //  rows
                int mirror = a.lenght - l;
                if (mirror >= 0 && mirror < a.length && k < a.length) {
                    System.out.print(a[mirror][k] + " ");
                }
            }
            System.out.println();
        }
}