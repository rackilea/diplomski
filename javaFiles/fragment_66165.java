private static void undoMove() {
    int column = moves[--counter];
    moves[counter] = 0;  
    long move = 1L << (--height[column-1] + ((column-1) * height.length));
    bitBoard[counter & 1] ^= move;
}