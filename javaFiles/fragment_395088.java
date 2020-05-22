public class Cell extends JPanel{
    private Cell shadowCell;
    public void setCellThisMapsTo(Cell otherCell){ this.shadowCell = otherCell; }
    public Cell getCellThisMapsTo(){ return shadowCell; }
    // ... all the other stuff
}

// ... wherever you initialize the playable and shadow grid
// get a list of the shadow Cells, randomized order
Cell[][] shadowGrid; // however you init this
Cell[][] playableGrid; // however you init this

LinkedList<Cell> shadowCells = new LinkedList<>();
for(int x = 0; x < 3; x++){
    for(int y = 0; y < 3; y++){
        shadowCells.add(shadowGrid[x][y]);
    }
}
Collections.shuffle(shadowCells);

for(int x = 0; x < 3; x++){
    for(int y = 0; y < 3; y++){
        Cell playableCell = playableGrid[x][y];
        Cell shadowCell = shadowCells.removeFirst();
        playableCell.setCellThisMapsTo(shadowCell );
    }
}

// Now all the playable cells map to a random shadow cell
Cell playableCell = playableGrid[0][0];
Cell shadowCell = playableCell.getCellThisMapsTo();