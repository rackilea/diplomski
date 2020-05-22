public void setNeighbor(MazeCell c, Direction d)
    {
        checked[d.ordinal()] = true;
        if (!c.isInMaze() && !c.hasNeighbor(oppositeOf(d)))
        {
            if (setNeighbor)
            {
                setNeighbor = false;
                c.setNeighbor(this, oppositeOf(d));
            }
            neighbors[d.ordinal()] = c;
        {
        setNeighbor = true;
        inMaze = true;
    }