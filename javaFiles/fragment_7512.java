public static int[] doubleDig(String cardNum, int length) {
    int[] nums = new int[length];
    int num;
    for (int x = 0; x < cardNum.length(); x++) {
        nums[x]=Integer.parseInt(cardNum.substring(x, x+1));
    }
    System.out.println(nums.length);
    return nums;
}