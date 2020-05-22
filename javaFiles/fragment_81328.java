for (int i = 1; i < memo.length; i++) {
    for (int j = 1; j < memo[i].length; j++) {
        if (memo[i-1][j]){
            //no need to take ith elements, first i-1 have sum j
            take[i][j] = false;
            memo[i][j] = true;
        }
        else if (j-set[i-1] >= 0 && memo[i-1][j-set[i-1]]){
            //take ith element, and search for set of size j-set[i-1] in 1..i-1
            take[i][j] = true;
            memo[i][j] = true;
        }
        else{
            //neither memo[i-1][j] or memo[i-1][j-set[i-1]] valid, so no way to make sum
            take[i][j]=false;
            memo[i][j]=false;
        }

    }
}