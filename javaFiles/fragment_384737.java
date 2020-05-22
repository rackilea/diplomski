void printSubsetSum(int []nums,int targetSum) {
    int n = nums.length;

    // generate all possible combination from binary representation
    for(int mask=(1<<n)-1;mask>0;mask--) {
        List<Integer> list = new ArrayList<Integer>();

        // check by bit operation
        for(int i=0;i<n;i++) {
            // if ith bit is on then we add our candidate number
            if((mask & (1<<i))!=0) list.add(nums[i]);
        }

        // sum all element in list
        int sum = 0;
        for(int x:list) sum += x;

        // if the sum equals targetSum then we print our list
        if(sum==targetSum) System.out.println(list);
    }
}