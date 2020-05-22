public static boolean constraint2(int [][] xmatrix, int [][] ymatrix){

    for(int l = 0; l < xmatrix.length; l++){
        for(int t = 0; t < xmatrix[l].length; t++){
            if(b[t]*xmatrix[l][t] > ymatrix[l][t]) {
                //constraint failed
                return false;
            }   
        }
    }
//constraint holds for all elements
return true;
}