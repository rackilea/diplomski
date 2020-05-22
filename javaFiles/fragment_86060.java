int nums_another[] = new int [nums.length];
    int i = 0;
    int j = 0;
    i++;
    int c = 1;
    while (i < nums.length){
        if (nums[i] == nums[i-1]) { // count identical numbers
            c++;
        }
        else { // not identical, store sum of previous identical numbers (possibly only 1 number)
            if (nums[i-1] != 0) {
                nums_another[j] = nums[i-1] * c;
                j++;
            }
            c = 1;
        }
        i++;
    }
    if (nums[i-1] != 0) { // store last
        nums_another [j] = nums[i-1] * c; 
    }