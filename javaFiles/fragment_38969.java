public class Main {

public static void main(String[] args) {

    int[] a = new int[]{35, 7, 63, 42, 24, 21};
    int[][] c = selectionsort(a);
    for (int i = 0; i < c.length; i++) {
        System.out.print("[  ");
        for (int j = 0; j < c[i].length; j++) {
            System.out.print(c[i][j] + "  ");
        }
        System.out.println("]");
    }
/*
 * expected printout
 * [  7  35  63  42  24  21  ]
 * [  7  21  63  42  24  35  ]
 * [  7  21  24  42  63  35  ]
 * [  7  21  24  35  63  42  ]
 * [  7  21  24  35  42  63  ]
 * [  7  21  24  35  42  63  ]
 */
}

public static int[][] sort(int[] a) {
    int result[][] = new int[a.length][a.length];

    for (int i = 0; i < a.length; i++) {
        for (int j = i + 1; j < a.length; j++) {
            if (a[i] > a[j]) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        for (int k = 0; k < a.length; k++) {
            result[i][k] = a[k];
        }
    }

    return result;
 }
}