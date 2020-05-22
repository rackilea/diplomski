public static void main(String args[]){
    int[] nums = {2, 3, 4, 5, 4, 5, 3};

    int pos4 = 0;
    for (int k = nums.length -1; k >= 0; k--) {
        if (nums[k] == 4){
            pos4 = k;
            break;
        }        
    }
    System.out.print(pos4); // moved outside of loop to print final value
}