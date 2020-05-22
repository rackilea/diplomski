private void rotate() {
    float[] animationMatrix = new float[16];
    Matrix.setIdentityM(animationMatrix, 0);

    // rotate in x and y direction, apply that to the intermediate matrix
    Matrix.rotateM(animationMatrix, 0, cube.getAngleX(), 1, 0, 0);
    Matrix.rotateM(animationMatrix, 0, cube.getAngleY(), 0, 1, 0);

    // concatenate the animation and the rotation matrix; the order is important
    Matrix.multiplyMM(animationMatrix, 0, animationMatrix, 0, mRotationMatrix, 0); 

    Matrix.multiplyMM(mMVPMatrix, 0, mMVPMatrix, 0, animationMatrix, 0);
}