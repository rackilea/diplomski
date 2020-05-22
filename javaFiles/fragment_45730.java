if (cube.getRotateDirection().equals(Cube.RotateDirection.LEFT) ||
    cube.getRotateDirection().equals(Cube.RotateDirection.RIGHT)) {
        if (!firstRotation && cube.getAngleY() % 90 == 0) {

            float[] newRotationMatrix = new float[16];
            Matrix.setIdentityM(newRotationMatrix, 0);
            Matrix.rotateM(newRotationMatrix, 0, cube.getAngleY(), 0, 1, 0);

            // concatenate the new 90 rotation to the rotation matrix
            Matrix.multiplyMM(mRotationMatrix, 0, newRotationMatrix, 0, mRotationMatrix, 0);

            // reset the angle
            cube.setAngleY(0);
            cube.setRotation(Cube.RotateDirection.NONE);
        }
    }
    if (cube.getRotateDirection().equals(Cube.RotateDirection.UP) ||
        cube.getRotateDirection().equals(Cube.RotateDirection.DOWN)) {
        if (!firstRotation && cube.getAngleX() % 90 == 0) {

            float[] newRotationMatrix = new float[16];
            Matrix.setIdentityM(newRotationMatrix, 0);
            Matrix.rotateM(newRotationMatrix, 0, cube.getAngleX(), 1, 0, 0);

            // concatenate the new 90 rotation to the rotation matrix
            Matrix.multiplyMM(mRotationMatrix, 0, newRotationMatrix, 0, mRotationMatrix, 0);

            // reset the angle
            cube.setAngleX(0);
            cube.setRotation(Cube.RotateDirection.NONE);
        }
    }