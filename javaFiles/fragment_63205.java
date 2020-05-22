private static Boolean isMagicSquare(int[][] array){
    int side = array.length;
    int magicNum = 0;
    for(int x = 0; x < side; ++x){
        magicNum += array[0][x];
    }
    int sumD = 0;
    for(int x = 0; x < side; ++x){
        int sumX = 0;
        int sumY = 0;
        for (int y = 0; y < side; ++y){
            sumX += array[x][y];
            sumY += array[y][x];
        }
        sumD =+ array[x][x];
        if(sumX != magicNum  || sumY != magicNum){
            return false;
        }
    }
    return sumD == magicNum;
}