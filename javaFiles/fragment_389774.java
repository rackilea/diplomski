public class Main {
    public static void main(String[] args) {
        int[] array2 = { 0, 0, 6, 0, 9, 5, 7, 9, 3 };
        for (int i = array2.length; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print(array2[j]);
            }
            System.out.println();
        }
    }
}