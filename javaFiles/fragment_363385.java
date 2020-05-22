GL11.glEnableClientState(GL11.GL_VERTEX_ARRAY);
ARBVertexBufferObject.glBindBufferARB(ARBVertexBufferObject.GL_ARRAY_BUFFER_ARB, vertexBufferID);
GL11.glVertexPointer(3, GL11.GL_FLOAT, 0, 0);

for (int i = 0; i < cubeCount; i++) {
  GL11.glPushMatrix();
  // do translation/rotation for cube no i
  GL11.glDrawArrays(GL11.GL_QUADS, 0, 24);
  GL11.glPopMatrix();
}

GL11.glDisableClientState(GL11.GL_VERTEX_ARRAY);