public static void main(String[] args) {
        String[][][] array3d = new String[10][10][10];

         for(String [] [] array2d : array3d){
             for(String[] array : array2d){
                 Arrays.fill(array, "hello");
             }
         }

         System.out.println(Arrays.deepToString(array3d));

    }