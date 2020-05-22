private void storeDataInAttributeList(int attributeNumber, float[] data) {
    int vboID = GL15.glGenBuffers();
    vbos.add(vboID);
    GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vboID);
    FloatBuffer buffer = storeDataInFloatBuffer(data);
    GL15.glBufferData(GL15.GL_ARRAY_BUFFER, buffer, GL15.GL_STATIC_DRAW);

    GL11.glVertexPointer( 3, GL11.GL_FLOAT, 0, 0 ); // <---------

    GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
}