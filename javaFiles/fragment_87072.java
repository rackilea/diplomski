public static long[][] blocksToMatrix( List<long[][]> blocks, int width, int height ) {
  long[][] yuvMatrix = new long[width][height];
  int c = 0;
  int r = 0;

  for( long[][] block : blocks ) {
    int blockWidth = block.length;
    int blockHeight = block[0].length;

    for( int bc = 0; bc < block.length; bc++ ) {
      for( int br = 0; br < block[bc].length; br++ ) {
        yuvMatrix[c + bc][r + br] = block[bc][br];
      }
    }

    //calculate the next offset into the matrix
    //The blocks where created in row-major order so we need to advance the offset in the same way
    r += blockHeight;
    if( r >= height ) {
      r = 0;
      c += blockWidth;
    }
  }

  return yuvMatrix;
}