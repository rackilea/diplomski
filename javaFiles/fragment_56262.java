//Added Spacer loop for getting perfect shape for  pascal triangle
        for(int spacer =n ; spacer > row ; spacer--){
            System.out.print(" ");
        }



       for (int col=0; col <= row; col++){
           System.out.print(pascalTriangle(row,col) + " ");
       }
       System.out.println();
   }