double expectedValue(int player, int start, int end, int[]set){
       if(start == end)
          if(player == 0)
             return set[start];
          return 0;
       if(already calculated this state)
          return dp[player][start][end];
       double result= 0;
       if(player == 0){
          result = 0.5*( set[start] + f(1, start + 1,end) ) + 0.5*(set[end] + f(1,start, end - 1));
       }else{
          result = 0.5*( f(0, start + 1,end) ) + 0.5*(f(0,start, end - 1));
       }
       return dp[player][start][end] = result;
  }