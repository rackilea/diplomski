public class Arrays1 {
    @SuppressWarnings("empty-statement")
    public static void main(String[] args) {
        int [] array1 = {7,10,5,100,80,40,15,60};
        int [] array2 = {10,100,80,5,15,7,60,40};
        for (int i = 0; i < array1.length; i++) {
            for (int j = 0; j < array2.length; j++) {
                if (array1[i] == array2[j]) {
                   System.out.println("(" + i + "," + j + ")");
                }
            }
        }
    }
}