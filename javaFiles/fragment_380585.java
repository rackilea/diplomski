public void render(RawModel model){
    GL30.glBindVertexArray(model.getVaoID());

    GL11.glEnableClientState( GL11.GL_VERTEX_ARRAY );   // <---------

    GL11.glDrawArrays(GL11.GL_TRIANGLES, 0, model.getVertexCount());

    GL11.glDisableClientState( GL11.GL_VERTEX_ARRAY );  // <---------

    GL30.glBindVertexArray(0);
}