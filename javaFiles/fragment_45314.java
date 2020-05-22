for(int l = 0; l < xmatrix.length; l++){
    if(xmatrix[0].length>0) {
        if(b[0]*xmatrix[l][0] > ymatrix[l][0]){
            return false;
        }
        else{
            return true;
        }   
    }
}