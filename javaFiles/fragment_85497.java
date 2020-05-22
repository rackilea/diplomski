Map<Integer, List<int[]>> map = new HashMap<>();
for (int i = 0; i < nums.length; ++i) {
  for (int j = i+1; j < nums.length; ++j) {
    if (nums[i] == nums[j] || nums[i]*nums[j] > 1024) continue;

    map.computeIfAbsent(nums[i]*nums[j], ArrayList::new)
        .add(new int[] {nums[i], nums[j]});
  }
}