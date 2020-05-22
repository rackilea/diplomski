public boolean firstLast6(int[] nums) {
    if (nums == null || nums.length == 0) {
        return false;
    }

    return nums[0] == 6 || nums[nums.length - 1] == 6;
}