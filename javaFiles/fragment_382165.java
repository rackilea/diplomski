public void render(){
    Main.TerrainDemo.shader.start();
    glPushMatrix();
    glDisable(GL_LIGHTING);
    glTranslatef(location.x * TerrainDemo.scale, location.y, location.z * TerrainDemo.scale);
    TexturedModel texturedModel = TerrainDemo.texModel;
    RawModel model = texturedModel.getRawModel();
    GL30.glBindVertexArray(model.getVaoID());
    GL20.glEnableVertexAttribArray(0);
    GL20.glEnableVertexAttribArray(1);
    GL13.glActiveTexture(GL13.GL_TEXTURE0);
    GL11.glBindTexture(GL11.GL_TEXTURE_2D, texturedModel.getTexture().getID());
    glScalef(10f, 10f, 10f);
    glColor4f(0, 0, 0, 0.5f);
    glDrawElements(GL_TRIANGLES, model.getVertexCount(), GL11.GL_UNSIGNED_INT, 0);
    GL20.glDisableVertexAttribArray(0);
    GL20.glDisableVertexAttribArray(1);
    GL30.glBindVertexArray(0);
    glEnable(GL_LIGHTING);
    glPopMatrix();
    Main.TerrainDemo.shader.stop();
}