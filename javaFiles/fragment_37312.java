public int sum13(int[] nums) {
  int sum = 0;
  for (int i = 0; i < nums.length; i++) {
    // we start by adding all the non-13s to the sum
    if (nums[i] != 13){
     sum += nums[i];
    }
    else {
     i++;
    }
  }
 return sum;
}