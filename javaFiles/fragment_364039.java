public static List<List<Integer>> twoPartSum2(int[] arr){

    // corner case

    List<List<Integer>> ret = new ArrayList<>();
    List<Integer> part = new ArrayList<>();

    if(arr == null || arr.length <= 1){
        ret.add(part);
        return ret;
    }

    // usual case

    Arrays.sort(arr); // make sure the same numbers will be lined together

    int sum = 0;
    for(int i : arr){
        sum += i;
    }

    helper2(arr, 0, sum/2, 0, ret, part);

    return ret;

}

private static void helper2(int[] arr, int curSum ,int target, int index, List<List<Integer>> ret, List<Integer> part){

    // base case 1: found the answer
    if(curSum == target){
        ret.add(new ArrayList<>(part));
        return;
    }

    // base case 2: solution not found
    if(index == arr.length || curSum > target){
        return;
    }

    // recursion case 1: adding current element in the candidate list ("part")
    part.add(arr[index]);
    helper2(arr, curSum + arr[index], target,index + 1,ret, part);
    part.remove(part.size()-1);

    // deduplicate the same elements
    while(index + 1 < arr.length && arr[index] == arr[index+1]){
        index++;
    }

    // recursion case 2: not adding current element in the candidate list ("part")
    helper2(arr, curSum, target, index + 1,ret,part);

}