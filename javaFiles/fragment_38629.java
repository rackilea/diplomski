private int dp(int[] a) {
    int[][] dp = new int[a.length+1][a.length+1];
    for(int p = a.length-1; p >=0; p--) {
        for(int i = a.length-1; i >p; i--) {
            dp[p][i] = dp[p][i+1]; // Try to leave the i-th item
            if(a[i] > a[p])        // Try to pick the i-th item
                dp[p][i] = Math.max(dp[p][i], 1 + dp[i][i+1]);
        }
    }
    return dp[0][1];
}