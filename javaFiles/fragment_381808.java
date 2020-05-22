public class SumArray {
    public static void main(String[] args) {
        int[] bills = new int[] { 2, 5, 7, 1 };
        int size = bills.length;

        for (int i = 0; i < size; i++) {
            int[] sum = new int[size];
            for (int j = 0; j < size; j++) {
                if (j == 0) {
                    sum[j] = bills[j];
                } else {
                    sum[j] += sum[j - 1] + bills[j];
                }
            }

            System.out.println(Arrays.toString(bills) + " : " + Arrays.toString(sum));

            int firstElement = bills[0];
            System.arraycopy(bills, 1, bills, 0, size-1);
            bills[size-1] = firstElement;
        }
    }
}