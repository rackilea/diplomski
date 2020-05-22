import java.util.Arrays;

public class SortingDemo {
    public static void main(String[] args) {
        int[] num1 = new int[] { 5, 6, 2, 8 };
        int[] num2 = new int[] { 1, 4, 10, 7 };

        // Combine both into thrid array
        int[] num3 = new int[num1.length + num2.length];
        System.arraycopy(num1, 0, num3, 0, num1.length);
        System.arraycopy(num2, 0, num3, num1.length, num2.length);

        // Sort third array
        mergeSort(num3);
        System.out.println(Arrays.toString(num3));

        // Largest number of two array
        System.out.println("Largest : " + num3[num3.length - 1]);
    }

    public static int[] mergeSort(int[] arrayData) {
        if (arrayData.length <= 1) {
            return arrayData;
        }

        int[] first = new int[arrayData.length / 2];
        int[] second = new int[arrayData.length - first.length];
        System.arraycopy(arrayData, 0, first, 0, first.length);
        System.arraycopy(arrayData, first.length, second, 0, second.length);

        mergeSort(first);
        mergeSort(second);

        merge(first, second, arrayData);
        return arrayData;
    }

    private static void merge(int[] first, int[] second, int[] result) {
        int iFirst = 0;
        int iSecond = 0;

        int j = 0;
        while (iFirst < first.length && iSecond < second.length) {
            if (first[iFirst] < second[iSecond]) {
                result[j] = first[iFirst];
                iFirst++;
            } else {
                result[j] = second[iSecond];
                iSecond++;
            }
            j++;
        }
        System.arraycopy(first, iFirst, result, j, first.length - iFirst);
        System.arraycopy(second, iSecond, result, j, second.length - iSecond);
    }
}