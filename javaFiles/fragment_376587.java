double[] coordinates;
for(int c = 0; c < coordinates.length; c++){
    double coord = coordinates[c];
    String temp = String.valueOf(coord);
    String [] temp2 = temp.split(".");
    int x = Integer.valueOf(temp2[0]);
    int y = Integer.valueOf(temp[1]);
    pixBool[x][y] = true;
}