for(int i = 1; i < n; i = i ∗ 2){                    ----------
 for(int j = 0; j < n; j++){            ----------             |
     if(i == j){                                  |            |
        for(int k = 0; k < n; k++){     ----      |            |
           // Do something elementary       | (n  | + n )      | * log(n)
        }                               ----      |            |
     }else{                                       |            |
        // Do another elementary thing            |            |
     }                                  ----------             |
 }                                                             |
}                                                              |
                                                   ------------