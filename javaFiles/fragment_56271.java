for (int i = 2; i< n; i++){
          if( n <= 3){
              System.out.println("Prime");
              break;
          }else if( n%i ==0){
               System.out.println("Not Prime");
               break;
          }else{
              System.out.println("Prime"); --> this line will be printed every time in your loop!
          }
        }