int [][] arr ={ {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
     {0,0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0,0},
     {0,0,0,0,0,1,1,1,0,1,1,1,1,0,0,0,0,0},
     {0,0,0,0,0,1,1,1,1,1,1,0,1,0,0,0,0,0},
     {0,0,0,0,0,0,1,1,1,1,0,1,1,0,0,0,0,0},
     {0,0,0,0,0,0,1,1,1,0,1,1,0,0,0,0,0,0} };



    int lowHorizontal =arr[0].length; // give it length of columns "how many columns
    int highHorizontal =0;

    for(int i=0; i<arr.length; i++){
        for(int j=0; j<arr[0].length; j++){

            if(arr[i][j] == 1 ){
                if(lowHorizontal > j) 
                    lowHorizontal = j;
            }
        }
    }

    for(int i=arr.length-1; i>=0; i--){
        for(int j=arr[0].length-1; j>=0; j--){
            if(arr[i][j]==1){
                if(highHorizontal < j)
                    highHorizontal = j;
            }
        }
    }


    for(int i=0; i<arr.length; i++){
        for(int j=lowHorizontal; j<=highHorizontal; j++){
            System.out.print(arr[i][j] +" ");
        }
        System.out.println();
    }