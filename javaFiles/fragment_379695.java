void revealAdjCells(Tile [][] t,int x, int y) {

    // if out of bounds **or** if already revealed, return
    if (!checkBounds(x,y) || t[x][y].getVisibleState()) {                    
        return;
    }


    t[x][y].setVisibleState(true); // reveal tile **here **

    // do recursion only if no neighbors
    if (t[x][y].getNeighbours() == 0) { 
        // t[x][y].setVisibleState(true); // not **here**

        revealAdjCells(t,x+1,y); 
        revealAdjCells(t,x-1,y);
        revealAdjCells(t,x,y-1);
        revealAdjCells(t,x,y+1);
    } else {
        return;
    }
}