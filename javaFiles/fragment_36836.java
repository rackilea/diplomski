public void depthFirstSearch(int x, int y, Tile[][] maze) {
    // Return method after every Tile is visited.
    if (this.visitedCounter == maze.length * maze[0].length) {
        this.stack.clear();
        return;
    }

    Tile currentTile = maze[x][y];
    Random r = new Random();
    int neighbourAmount = currentTile.getNeighbourAmount();
    boolean allNeighboursVisited = false;
    int stopCounter = 0;

    // If it is a new Tile, mark it as visited
    if (!currentTile.isVisited()) {
        currentTile.setVisited(true);
        this.visitedCounter++;
        stack.add(currentTile);
    }

    // Check if neighbours are not yet visited and "visit" one of them.
    while (!allNeighboursVisited) {
        int random;
        do {
            random = r.nextInt(neighbourAmount);
        } while (this.excludeList.contains(random));

        Tile neighbour = currentTile.getNeighbours().get(random);
        if (!neighbour.isVisited()) {
            if (neighbour.getX() == currentTile.getX() - 1) {
                currentTile.getWall(4).setOpen(true);
                neighbour.getWall(2).setOpen(true);
            } else if (neighbour.getX() == currentTile.getX() + 1) {
                currentTile.getWall(2).setOpen(true);
                neighbour.getWall(4).setOpen(true);
            } else if (neighbour.getY() == currentTile.getY() - 1) {
                currentTile.getWall(1).setOpen(true);
                neighbour.getWall(3).setOpen(true);
            } else if (neighbour.getY() == currentTile.getY() + 1) {
                currentTile.getWall(3).setOpen(true);
                neighbour.getWall(1).setOpen(true);
            }
            this.excludeList.clear();
            depthFirstSearch(neighbour.getX(), neighbour.getY(), maze);
            return;
        } else {
            this.excludeList.add(random);
            stopCounter++;
        }

        if (stopCounter == neighbourAmount) {
            allNeighboursVisited = true;
        }
    }

    // If every neighbour has already been visited, go back one Tile.
    if (!this.stack.isEmpty()) {
        this.stack.remove(this.stack.size() - 1);
        if (!this.stack.isEmpty()) {
            Tile backtrackTile = this.stack.get(this.stack.size() - 1);
            this.excludeList.clear();
            depthFirstSearch(backtrackTile.getX(), backtrackTile.getY(), maze);
            return;
        }
        this.excludeList.clear();
    }
}