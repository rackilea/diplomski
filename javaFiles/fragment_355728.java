public int[] copyEvens(int[] nums, int count) {
  int counter = 0;
  int[] countArr = new int [count];
  for (int i = 0; i < nums.length && counter < count; i++) 
    if ((nums[i] % 2) == 0) 
        countArr[counter++] = nums[i];
  return countArr;
}