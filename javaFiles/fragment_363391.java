// nested for, from top left to bottom right.
for(int x = 0; x < sizeOfMazeX; x++) {
    for(y = 0; y < sizeOfMazeY; y++) {
        // if [x-1][y] contains right, [x][y] must contain left.
        if(x > 0 && block[x-1][y] & BLOCK_RIGHT != 0)
            block[x][y] |= BLOCK_LEFT;
        // if [x][y-1] contains bottom, [x][y] must contain top.
        if(y > 0 && block[x][y-1] & BLOCK_BOTTOM != 0)
            block[x][y] |= BLOCK_TOP;
        // add n other random directions to make it feel random.
    }
}