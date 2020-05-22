class StackOv {

    public static void main(String[] args) {
        int arraySize = 10;
        int[] numsToSum = new int[arraySize];
        for (int i = 0; i < arraySize; i++)
        {
                numsToSum[i] = i * 3;
                System.out.println(numsToSum[i]);
        }
        int sum3 = sumArray3(numsToSum, 0, arraySize - 1);
        System.out.println(sum3);
    }

    public static int sumArray3(int [] array, int start, int end)
    {
        int results = 0;
        if(start == end)
            return array[start];
        int mid = (start + end)/2;
        if(array.length > 0) {
                results += sumArray3(array, start, mid) + sumArray3(array, mid +1, end);
        }
        return results;
    }
}