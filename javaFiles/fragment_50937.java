public int[][] fill(){ 
        int[][] data = new int[row][col]; 
        Scanner in = new Scanner(System.in);
        for(int row = 0; row< matrix.length; row++){ 
              for(int col = 0 ;col< matrix[row].length; col++){ 
                   System.out.println("enter the elementss for the Matrix"); 
                  data[row][col] = in.nextInt(); 
               } System.out.println(); 
          } 

           for(int row = 0; row< matrix.length; row++){
       for(int col = 0 ;col< matrix[row].length; col++){ 
             System.out.println(data[row][col]);
       } 
      System.out.println(); 
   }
         return data;