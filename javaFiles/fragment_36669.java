public static void getSum(int[] numbersArray, int starting, int sum)
{
    if(numbersArray.length == starting)
    {
        // Now we print sum here
        System.out.println(sum);
        return;
    }

    int value = sum + numbersArray[starting];

    getSum(numbersArray, starting + 1, value);
    getSum(numbersArray, starting + 1, sum);
}