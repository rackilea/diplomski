for(int i = 1; i < nums.length-1; i++) { // Why do I start i at 1?
  if(nums[i]==2) {
    if(nums[i-1] == 2 || nums[i+1] == 2) // What does this if check?
      do something; // What to do here?  Look up the 'continue' keyword.
    else
      return false;
  }
}
return true;