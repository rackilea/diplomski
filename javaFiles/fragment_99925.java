public float[] calculateWorld2CameraMatrix(float[] modelmtx, float[] viewmtx, float[] prjmtx) {

    float scaleFactor = 1.0f;
    float[] scaleMatrix = new float[16];
    float[] modelXscale = new float[16];
    float[] viewXmodelXscale = new float[16];
    float[] world2screenMatrix = new float[16];

    Matrix.setIdentityM(scaleMatrix, 0);
    scaleMatrix[0] = scaleFactor;
    scaleMatrix[5] = scaleFactor;
    scaleMatrix[10] = scaleFactor;

    Matrix.multiplyMM(modelXscale, 0, modelmtx, 0, scaleMatrix, 0);
    Matrix.multiplyMM(viewXmodelXscale, 0, viewmtx, 0, modelXscale, 0);
    Matrix.multiplyMM(world2screenMatrix, 0, prjmtx, 0, viewXmodelXscale, 0);

    return world2screenMatrix;