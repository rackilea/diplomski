public static int[] fix45(int[] nums) {

      int j = 0;
      for (int i = 0; i < nums.length - 1; ++i) {
        if (nums[i] == 4 && nums[i + 1] != 5) {
          /*
           * Need to find the next movable 5 That means an element that is 5 and
           * either is the first element or is preceded by anything other than 4
           */
          while (nums[j] != 5 || (j != 0 && nums[j - 1] == 4)) {
            j++;
          }
          nums[j] = nums[i + 1];
          nums[i + 1] = 5;
        }
      }
      return nums;
    }