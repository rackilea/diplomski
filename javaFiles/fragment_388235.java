public class Sort {
    private static int[] array = { 3, 8, -1, 7, 0, 3 };

    public static void main(String[] args) {

        for(int i = 0; i < array.length - 1; i++) {
            for(int j = i + 1; j < array.length; j++) {

                if(array[i] > array[j]) {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        for(int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }
}