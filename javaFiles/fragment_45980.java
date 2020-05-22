public class ArrayThings {
    public static void main(String[] args) {
        int[] myFirstArray = new int[100];

        // array generation
        for (int i = 0; i < myFirstArray.length; i++) {
            myFirstArray[i] = i;
        }
        // printing multiples of 10
        for (int i = 0; i < myFirstArray.length; i++) {
            if (i % 10 == 0 && i != 0) {
                System.out.println(myFirstArray[i]);
            }
        }
    }
}