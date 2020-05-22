private static int[] bubblesort(int[] nums)
{
    boolean done = false;

    for (int i = 0;  i < nums.length && !done; i++)
    {
        done = true;

        for (int j = nums.length-1; j > i; j--)
        {
            if (nums[j] < nums[j-1])
            {
                int temp = nums[j];
                nums[j] = nums[j-1];
                nums[j-1] = temp;
                done = false;
            }
        }
    }

    return nums;
}