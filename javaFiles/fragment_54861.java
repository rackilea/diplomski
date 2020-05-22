void paintMaze(Graphics g) {
    for (int x = 0; x < maze.getHeight(); x++) {
        System.out.println("|");
        for (int y = 0; y < maze.getWidth(); y++) {
            Cell current = maze.getMaze()[x][y];
            if(current.isWestWall()) {
                g.setColor(Color.black);
                g.drawLine((y+1)*seventhHeight, x*seventhHeight, (y+1)*seventhHeight, x*seventhHeight + seventhHeight);
            }

            if(current.isNorthWall()){
                g.drawLine((y+1)*seventhHeight, x*seventhHeight,(y+1)*seventhHeight + seventhHeight, x*seventhHeight);
            }

            if(current.isEastWall()) {
                g.drawLine((y+1)*seventhHeight + seventhHeight, x*seventhHeight, (y+1)*seventhHeight + seventhHeight, x*seventhHeight + seventhHeight);
            }

            if(current.isSouthWall()) {
                g.drawLine((y+1)*seventhHeight, x*seventhHeight + seventhHeight, (y+1)*seventhHeight + seventhHeight, x*seventhHeight +seventhHeight);
            }

        }
    }
}