private void newCell() {
    List<Integer> availableCells = new ArrayList<>();
    for (int i = 0; i < 16; i++) {
        int x = i / 4 ;
        int y = i % 4 ;
        if (cell[x][y] == 0) {
            availableCells.add(i);
        }
    }
    int nextCell = availableCells.get((int)(Math.random() * availableCells.size()));
    cell[nextCell / 4][nextCell % 4] = twoOrFour();
}