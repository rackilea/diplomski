public static int quadratic(int[] nums) {

    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < nums.length; i++) {
        for (int j = 0; j < nums.length; j++) {

            if (nums[j] > max)
                max = nums[j];
            if (nums[j] < min)
                min = nums[j];  
            }
        }
    System.out.println(max + " " + min);
    int maxDifference = max - min;
    return maxDifference; 
}