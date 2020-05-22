int xSize = dis.readInt();
   int ySize = dis.readInt();
   for (int x=0; x<xSize; x++) {
        for (int y=0; y<ySize; y++) {
              double value = dis.readDouble();
              matrix[x,y] = value;
        }
   }