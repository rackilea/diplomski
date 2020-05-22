public static void Draw(float vertices[], int verticesCount, float color[]) {
    vertexBuffer.put(vertices);
    vertexBuffer.position(0);

    GLES20.glEnableVertexAttribArray(sPosition);
    GLES20.glVertexAttribPointer(sPosition, 3, GLES20.GL_FLOAT, false, 0, vertexBuffer);

    colorBuffer.put(color);
    colorBuffer.position(0);

    GLES20.glEnableVertexAttribArray(sColor);
    GLES20.glVertexAttribPointer(sColor, 4, GLES20.GL_FLOAT, false, 0, colorBuffer);

    GLES20.glDrawArrays(GLES20.GL_TRIANGLE_STRIP, 0, verticesCount);  // Draw

    GLES20.glDisableVertexAttribArray(sPosition);
    GLES20.glDisableVertexAttribArray(sColor);
}