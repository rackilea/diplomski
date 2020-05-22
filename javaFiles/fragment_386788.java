for(int i=0; i<n; i++){
          if(!B.get(i).equals(A.get(i))){
              for(int j=0; j<n; j++){
                  if(A.get(j).equals(B.get(i))){
                      Collections.swap(B, j, i);
                      System.out.println("Swapping "+i+" with "+j+" : "+B);
                      count++;
                  }
              }
          }
      }