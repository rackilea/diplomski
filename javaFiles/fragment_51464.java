for(int y = 0; y < twoDArray.length; y++) {
    for(int x = 0; x < twoDArray[y].length; x++) {
        int oneDIndex = (twoDArray[y].length * y) + x;
        oneDArray[oneDIndex] = twoDArray[y][x];
    }
}