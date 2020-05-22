public int minPathSum(int[][] grid, int i, int j, int[][] memo) {
        if(i == grid.length-1 && j == grid[0].length-1) {
            memo[i][j] = grid[i][j];
            return grid[i][j];
        }
        else if(i>=grid.length || j >= grid[0].length) {
            return 10000;
        }
        else {
            int val = grid[i][j]+Math.min(minPathSum(grid,i+1,j, memo), minPathSum(grid,i,j+1, memo));
            if(memo[i][j] > val || memo[i][j] == 0){
                memo[i][j] = val;
            }
            for(int k = 0;k<memo.length;k++){
                System.out.println(Arrays.toString(memo[k]));
            }
            System.out.println("i:"+i+" j:"+j);
            return memo[i][j];
        }
    }