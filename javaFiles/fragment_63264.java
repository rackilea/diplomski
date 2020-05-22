public static boolean isSymetric(int[][] array){
    for(int a = 0; a < array.length; a++){ 
        for(int b = 0; b < array.length; b++){
            if(array[a][b]!=array[b][a]){
                return false;
            }
        }
    }
    return true;
}