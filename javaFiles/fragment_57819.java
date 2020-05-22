public static void printMaze(final Cell[][] maze) {
    for (int r = 0; r < maze.length; r++) {
        final Cell[] row = maze[r];
        printTop(row);
        printMiddle(row);
        if (r == maze.length - 1) {
            printBottom(row);
        }
    }
}

private static void printBottom(final Cell[] row) {
    for (final Cell cell : row) {
        System.out.print(cell.walls.contains(Dir.SOUTH) ? "+--" : "+  ");
    }
    System.out.println("+");
}

private static void printMiddle(final Cell[] row) {
    for (int c = 0; c < row.length; c++) {
        final Cell cell = row[c];
        System.out.print(cell.walls.contains(Dir.WEST) ? "|  " : "   ");
        if (c == row.length - 1) {
            System.out.println(cell.walls.contains(Dir.EAST) ? "|" : " ");
        }
    }
}

private static void printTop(final Cell[] row) {
    for (final Cell cell : row) {
        System.out.print(cell.walls.contains(Dir.NORTH) ? "+--" : "+  ");
    }
    System.out.println("+");
}