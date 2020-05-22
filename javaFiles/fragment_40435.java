for ( int i =0; i < myData.length; i++ ){

        for (  int j =0; j < myData[i].length; j++ ){
           // you were printing the 1-D array, which prints hashcode
            System.out.print( (myData[i][j]) + " ");
        }

        System.out.println();
    }