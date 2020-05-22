public static void main(String[] args) {

    Random rand = new Random();
    int[] nums =  new int [10];

    while (stopTest(nums)){
        int i = rand.nextInt(10);
        nums[i]++;
    }
    //print to test
    System.out.println(Arrays.toString(nums));
}

private static boolean stopTest(int[] array) {

    for(int i: array) {
        if (i<1)    return true;
    }
    return false;
}