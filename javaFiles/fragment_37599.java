public class ArreglosMultidimensionales {
    public static void llamarArreglo(int[][] array) {
        int i;
        int j;
        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array[i].length; j++) {

                if (i == j) {
                    array[i][j] = 1;
                } else {
                    array[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[3][3];
        llamarArreglo(arr);
    }
}