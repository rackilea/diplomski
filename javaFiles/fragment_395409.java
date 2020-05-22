int i = 0;
while(i < 3) {
    int x = rn.nextInt(3);
    int y = rn.nextInt(3);
    if (grid[x][y] != 'O') {
        grid[x][y] = 'O';
        i++;
    }  
}