int findSumBottomTop(int[] tree , int height){
    //initialize counter for previous level
    int[] sums = new int[height + 1]
    fill(sums , 0)

    //counter for the level counts down to 1 (note that this variable is not 0-based!!!)
    int lvl = height

    //counter for nodes remaining on the current level (0-based)
    int remaining_in_lvl = lvl - 1
    //maximum-paths for each node on the current level
    int[] next_level = new int[lvl]

    //iterate over all nodes of the tree
    for(int node = length(tree) - 1; node > -1 ; node--){
        int left_max_path = sums[remaining_in_lvl]
        int right_max_path = sums[remaining_in_lvl + 1]

        next_level[remaining_in_lvl] = max(right_max_path , left_max_path) + tree[node]

        //decrement counter for remaining nodes
        remaining_in_lvl -= 1

        if(remaining_in_lvl == -1){
            //end of a level was encountered --> continue with lvl = lvl - 1
            lvl--
            //update to match length of next 
            remaining_in_lvl = lvl - 1

            //setup maximum-path counters for next level
            sums = next_level
            next_level = new int[sums.length - 1]
     }

     //there is exactly one sum remaining, which is the sum of the maximum-path
     return sums[0];
 }