static int maxNumber(int[] mArray){//Passing int array as parameter
        int max=mArray[0];
        for(int i=0;i<mArray.length;i++){
            if(max<mArray[i]){//Calculating max Number
                max=mArray[i];
            }
        }

        return max;//Return Max Number.
    }