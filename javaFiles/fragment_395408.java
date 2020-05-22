for(int row = 0; row<grid.length; row++) {
    for(int col = 0; col<grid[row].length; col++) {
        grid[row][col] = 'N'; 
    }
}
for(int i = 0; i<3; i++) {
    grid[rn.nextInt(3)][rn.nextInt(3)] = 'O';  
}