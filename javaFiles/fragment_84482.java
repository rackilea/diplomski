public int maxSpan(int[] nums) {
  int maxSpan = 0;
  int span;
  int j;
  for(int i = 0; i < nums.length; i++)
  {
     for(j = nums.length - 1; nums[i] != nums[j]; j--)
     {
         span = 1 + j - i;
         if(span > maxSpan)
            maxSpan = span;
     }
  }
  return maxSpan;
}