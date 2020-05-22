int temp = 0;
    int[] nums = new int[]{4, 2, 1, 3, 6, 8, 5, 7};
    for (int i = 0; i < nums.length; i++) {
        while (nums[i] != nums[nums[i] - 1]) {
            temp = nums[i];
            int index = nums[i] - 1;
            nums[i] = nums[nums[i] - 1];
            nums[index] = temp;
        }
    }

    for (int i : nums) {
        System.out.println(i);
    }