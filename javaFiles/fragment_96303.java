// pseudocode only
for(Cell foo : all cells in top row)
    checkCell(foo);

boolean checkCell(Cell current) {
    if(current == false)
        return false;

    if(current == true && current.isInLastRow == true)
        return true;

    // if we reach here, the cell is true but we're not done
    for(Cell foo : all valid neighbors of this cell except the "parent")
        return checkCell(foo);
}