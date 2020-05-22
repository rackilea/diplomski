for (int y = 2; y < GRID_HEIGHT; y++) {
    for (int x = 2; x < GRID_WIDTH; x++) {
        if (    
                state[y][x] != Player.NONE && 
                state[y][x] == state[y-1][x-1] &&
                state[y-1][x-1] == state[y-2][x-2]
                ) return state[y][x];
    }
}