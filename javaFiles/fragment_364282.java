if(tempMatrix[x][y] == 1){
            if(neighbor_count == 1 || neighbor_count > 3) {
                outputMatrix[x][y] = 0;
            }
            else{
                outputMatrix[x][y] = 1;
            }
        }else if(neighbor_count == 3){
            outputMatrix[x][y] = 1;
        }else{
            outputMatrix[x][y] = 0;
        }