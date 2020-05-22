public boolean haveThree(int[] nums) {
    int count = 0;
    for (int i=0;i<nums.length-1;i++) {
        if (nums[i] == 3 && nums[i+1] ==3) {
            return false;
        } 
        if ((nums[i]==3)) { //removed redundant condition and doesn't need to be an else
            count ++;
        }
    }
    // check the last index, you've already ensured the second to last is not also a 3
    if(nums[nums.length-1] == 3) {
        count++;
    }
    return count == 3;
}