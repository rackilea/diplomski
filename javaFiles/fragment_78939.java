for(int i = 0; i < nums.length; i++) {
        if((i + 1) < nums.length && (nums[i] != nums[i + 1])) {
            nums[size] = nums[i];
            size++;
        }
        else if(i + 1 == nums.length) 
            num[size] = nums[i];
     }