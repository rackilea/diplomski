/**
    * This will find how many pairs of numbers in the given array sum
    * up to the given number.
    *
    * @param array - array of integers
    * @param sum - The sum
    * @return int - number of pairs.
    */
public static int sumOfSubset(int[] array, int sum)
{
        // This has a complexity of O ( n lg n )
        Arrays.sort(array);

        int pairCount = 0;
        int leftIndex = 0;
        int rightIndex = array.length - 1;

        // The portion below has a complextiy of
        //  O ( n ) in the worst case.
        while (array[rightIndex] > sum + array[0])
        {
            rightIndex--;    
        }

        while (leftIndex < rightIndex)
        {
            if (array[leftIndex] + array[rightIndex] == sum)
            {
                pairCount++;
                leftIndex++;
                rightIndex--;
            }
            else if(array[leftIndex] + array[rightIndex]  < sum)
            {
                leftIndex++;
            }
            else
            {
                rightIndex--;   
            }
        }

        return pairCount;
}