// Draw the cube
public void draw(GL10 gl) { 
    // ...

    //Enable vertex and texture client
    gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
    gl.glVertexPointer(3, GL10.GL_FLOAT, 0, vertexBuffer);
    gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);  // Enable texture-coords-array (NEW)
    gl.glTexCoordPointer(2, GL10.GL_FLOAT, 0, texBuffer); // Define texture-coords buffer (NEW)

    // choose which texture to use on the cube
    int GL_id_slot = 0;
    if (main.imagenes == R.raw.imagen)
        GL_id_slot = 0;
    else if (main.imagenes == R.raw.imagen2)
        GL_id_slot = 1;
    gl.glBindTexture(GL10.GL_TEXTURE_2D, textureIDs[GL_id_slot]);

    //Draw all the faces
    // ...
}