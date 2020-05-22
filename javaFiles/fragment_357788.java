double high = Double.MIN_VALUE;
    double low = Double.MAX_VALUE; 

    for(int i = 0; i < dmtData.length; i++){
        for(int j = 0; j < dmtData[i].length; j++){
            if(dmtData[i][j] > high){
                high = dmtData[i][j];
            }
            else if(dmtData[i][j] < low){
                low = dmtData[i][j];
            }
        }
    }