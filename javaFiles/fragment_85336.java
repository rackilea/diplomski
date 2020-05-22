public class Test {

    public static void main(String args[]) {
        int[] arr = new int[5];
        arr = new int[] { 1, 2, 3, 4, 5 };

        Test test = new Test();
        test.arrPrint(arr);

    }

    public void arrPrint(int[] arr) {
        for (int i = 0; i < arr.length; i++)
            System.out.println(arr[i]);

    }
}