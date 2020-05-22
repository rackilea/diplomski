// fill tmpMines array
for(int i = 0; i < x; i++) {
    for (int j = 0; j < y; j++) {
        if (numMines > 0) {
            numMines--;
            tmpMines[i][j] = true;
        } else {
            tmpMines[i][j] = false;
        }
    }
}
// shuffle tmpMines array
for(int i = 0; i < x; i++) {
    for (int j = 0; j < y; j++) {
        // int swapPos = rand.nextInt(x*y);  this swapPos selection is not correct, please use the code next line.
        int swapPos = x*y - rand.nextInt(x*y-i*y+j);
        int swapPosY = swapPos / x;
        int swapPosX = swapPos % x;

        boolean tmp = tmpMines[i][j];
        tmpMines[i][j] = tmpMines[swapPosX][swapPosY];
        tmpMines[swapPosX][swapPosY] = tmp;
    }
}