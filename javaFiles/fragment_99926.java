double[] world2Screen(int screenWidth, int screenHeight, float[] world2cameraMatrix)
  {
    float[] origin = {0f, 0f, 0f, 1f};
    float[] ndcCoord = new float[4];
    Matrix.multiplyMV(ndcCoord, 0,  world2cameraMatrix, 0,  origin, 0);

    ndcCoord[0] = ndcCoord[0]/ndcCoord[3];
    ndcCoord[1] = ndcCoord[1]/ndcCoord[3];

    double[] pos_2d = new double[]{0,0};
    pos_2d[0] = screenWidth  * ((ndcCoord[0] + 1.0)/2.0);
    pos_2d[1] = screenHeight * (( 1.0 - ndcCoord[1])/2.0);

    return pos_2d;
  }