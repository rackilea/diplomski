public int[] shiftLeft(int[] nums) {
    if (nums == null || nums.length <= 1) {
        return nums;
    }
    int start = nums[0];
    System.arraycopy(nums, 1, nums, 0, nums.length - 1);
    nums[nums.length - 1] = start;
    return nums;
}