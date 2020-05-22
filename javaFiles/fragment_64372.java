int vertexHandle;
int textureHandle;

private void init() throws IOException {
    Camera.init();
    texture = TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("test.png"));
    this.initialize3D();
    vertexHandle = GL15.glGenBuffers();
    FloatBuffer positionData = BufferUtils.createFloatBuffer(72);
    // Initalize position data.
    positionData.flip();

    GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER,vertexHandle);
    GL15.glBufferData(GL15.GL_ARRAY_BUFFER,positionData,GL15.GL_STATIC_DRAW);
    GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER,0);

    FloatBuffer textureData = BufferUtils.createFloatBuffer(72);
    // Initialize texture data.
    textureBuffer.flip();

    textureHandle = GL15.glGenBuffers();
    GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, textureHandle);
    GL15.glBufferData(GL15.GL_ARRAY_BUFFER, textureData, GL15.GL_STATIC_DRAW);
    GL11.glTexCoordPointer(3, GL11.GL_FLOAT, 0, 0);
    GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, 0);
    GL11.glDisableClientState(GL11.GL_TEXTURE_COORD_ARRAY);
}

public void render() {
    GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
    GL11.glLoadIdentity();
    texture.bind();
    GL11.glPushMatrix();
    GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, vertexHandle);
    GL11.glVertexPointer(3, GL11.GL_FLOAT, 0, 0L);
    GL15.glBindBuffer(GL15.GL_ARRAY_BUFFER, textureHandle);
    GL11.glVertexPointer(3, GL11.GL_FLOAT, 0, 0L);
    GL11.glDrawArrays(GL11.GL_QUADS, 0, 24);
    GL11.glPopMatrix();
}