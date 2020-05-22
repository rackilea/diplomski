int[] x1 = { 1, 2, 3, 4, 5 };
        int[] x2 = { 6, 7, 8, 9, 10 };
        int[][] y = { x1, x2 };

        for(int i=0;i<y.length;i++){
            for(int k=0;k<y[i].length;k++){
                System.out.println(y[i][k]);
            }
        }