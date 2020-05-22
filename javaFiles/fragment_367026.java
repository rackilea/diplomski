gl.glEnableClientState(GL10.GL_NORMAL_ARRAY);

// I'm assuming you know how to put it into a FloatBuffer.
gl.glNormalPointer(GL10.GL_FLOAT, 0, mNormalsBuffer);

// Draw your surface...