public class Testing {

    private static int InfThanZero(int[] elems) {

        int i = 0;
        for (int element : elems) {
            if (element < 0) {
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int sum = 0;
        for (String s : args) {
            if (Integer.parseInt(s) < 0) {
                sum++;
            }
        }
        System.out.println(sum);
    }
}