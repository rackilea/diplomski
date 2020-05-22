bool rec(idx1, idx2, idxS ){
    if(idx1 == part1.length && idx2 == part2.length){
        if(idxS == S.length) return true; //everything matched
        return false; //S has remaining

    }
    if(idxS == S.length){ //length part1 + part2 is more than S
        return false;
    }
    if(mark[idx1][idx2][idxS] == true) //computed before
        return dp[idx1][idx2][idxS];

    mark[idx1][idx2][idxS] = true;
    dp[idx1][idx2][idxS] = false;

    if(idx1 < part1.length && part1[idx1] == S[idxS]){
        if(rec(idx1 + 1, idx2, idxS + 1) == true) {
            dp[idx1][idx2][idxS] = true;
        }
    }
    if(idx2 < part2.length && part2[idx2] == S[idxS]){
        if(rec(idx1, idx2 + 1, idxS + 1) == true){
            dp[idx1][idx2][idxS] = true;
        }
    }
    return dp[idx1][idx2][idxS];
}