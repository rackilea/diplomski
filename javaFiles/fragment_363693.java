// Draw triangle

// Actually use the program
GLES30.glUseProgram(shader.getProgramHandle());

GLES30.glBindVertexArray(vaoHandle);
GLES30.glDrawElements(GLES30.GL_TRIANGLES, 3, GLES30.GL_UNSIGNED_INT, 0);
GLES30.glBindVertexArray(0);

GLES30.glUseProgram(0);