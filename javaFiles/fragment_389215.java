public static boolean isUnique(int[] nums){
    Set<Integer> set = new HashSet<>(nums.length);

    for (int a : nums) {
        if (!set.add(a))
            return false;
    }

    return true;
}