GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, mVertexBuffer);
GLES20.glEnableVertexAttribArray(aPositionLocation);
GLES20.glVertexAttribPointer(aPositionLocation, 3,
    GLES20.GL_FLOAT, false, sphere.getVerticesStride(), 0);

GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, mVertexBuffer);
GLES20.glEnableVertexAttribArray(aTextureCoordLocation);
GLES20.glVertexAttribPointer(aTextureCoordLocation, 2,
    GLES20.GL_FLOAT, false, sphere.getVerticesStride(), 12);