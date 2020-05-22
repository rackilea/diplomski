StringBuilder res = new StringBuilder();
String newline = System.getProperty("line.separator");
for (int row = 0 ; row < grid.length ; row++) {
    for (int col = 0 ; col < grid[row].length ; col++) {
        res.append('[');
        res.append(grid[row][col]);
        res.append(']');
    }
    // Do not append the trailing newline
    if (row != grid.length-1) {
        res.append(newline);
    }
}
return res.toString();