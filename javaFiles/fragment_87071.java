public static List<long[][]> matrixToBlocks(long[][] yuvMatrix, int blockDimension){    
  //Check matrix and block dimension match
  if( yuvMatrix.length == 0 || yuvMatrix.length % blockDimension != 0 
    || yuvMatrix[0].length == 0 || yuvMatrix[0].length % blockDimension != 0 ) {
    throw new IllegalArgumentException("whatever message you like");
  }

  List<long[][]> blocks = new ArrayList<long[][]>();

  //Iterate over the blocks in row-major order (down first, then right)
  for( int c = 0; c < yuvMatrix.length; c += blockDimension ) {
    for( int r = 0; r < yuvMatrix[c].length; r += blockDimension ) {
      long[][] subBlock = new long[blockDimension][blockDimension];

      //Iterate over the block in row-major order
      for(int bc = 0; bc < blockDimension; bc++ ) {
        for(int br = 0; br < blockDimension; br++ ) {
          subBlock[bc][br]=yuvMatrix[c+bc][r+br];
        } 
      }    

      blocks.add(subBlock);
    }
  }

  return blocks;
}