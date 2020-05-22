//A.length will give you the length of the first dimension (2)
 for(int i=0; i<A.length; i++){
            for(int j=0; j<n; j++){
                A[i][j] = (int) (Math.random()*10);
            }
        }
    }
 System.out.println(A[1][n-1]);
 System.out.print("Distance between exit i and exit j is: " + distance());