class JavaApplication16 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //illegal start of expression, ']' expected, <identifier> expected
        boolean a = groupSum(0, new int[]{2,4,8}, 10);
    }
    public static boolean groupSum(int start, int[] nums, int target) {
        if (start >= nums.length) return (target == 0);

        if (groupSum(start + 1, nums, target - nums[start])) return true;
        if (groupSum(start + 1, nums, target)) return true;

        return false;
    }
}