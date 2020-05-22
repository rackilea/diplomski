int[][] coords = new int[15][24];
BufferedReader br = new BufferedReader(new FileReader("/path/to/file"));

int row = 0;
String line = null;
while ((line = br.readLine()) != null) {
    // remove "[ ]" then split by ","
    String[] x = line.substring(1, line.length() - 1).split(",");
    // parse first 24 values only
    int cols = Math.min(x.length, 24);
    for (int col = 0; col < cols; col++) {
        coords[row][col] = Integer.parseInt(x[col]);
    }
    if (++row >= 15) break; // parse first 15 lines only
}

for (int i = 0; i < coords.length; i++) {
    for (int j = 0; j < coords[i].length; j++) {
        System.out.print(coords[i][j]);
    }
    System.out.println();
}