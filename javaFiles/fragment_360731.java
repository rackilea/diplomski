dos.write(xSize);
    dos.write(ySize);
    for (int x=0; x<xSize; x++) {
        for (int y=0; y<ySize; y++) {
            value = matrix[x,y];
            dos.write(value);
        }
    }