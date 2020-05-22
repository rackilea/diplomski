public int[] rotateLeft(int[] nums){
  if(nums.length == 0)
    return new int[0];

  int temp = nums[0];
  //This loop starts at index 1 because we are moving
  //    elements left, and 0 can't move left.
  for(int index = 1; index < nums.length; index++){
    nums[index-1] = nums[index];
  }

  nums[nums.length-1] = temp;
}