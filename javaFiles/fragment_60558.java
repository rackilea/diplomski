for (int i = 0; i < lightArray.length; i++){
    for(int j = 0; j <lightArray[0].length; j++) {
       if (lightArray[i][j] == true) return false;
    }
 }

 return true;