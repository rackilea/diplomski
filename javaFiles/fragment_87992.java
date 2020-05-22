public void drawBillBoardSprite(Texture texture, Vector3f sprPos, float r, float g, float b, int sprWidth, int sprHeight){
         // store the current model matrix
        GL11.glPushMatrix();
            GL11.glTranslatef(sprPos.x, 0, sprPos.z);
            // bind to the appropriate texture for this sprite
            texture.bind();

            FloatBuffer modelview = BufferUtils.createFloatBuffer(16);

            // get the current modelview matrix
            GL11.glGetFloat(GL11.GL_MODELVIEW_MATRIX, modelview);

            // Note that a row in the C convention is a column 
            // in OpenGL convention (see the red book, pg.106 in version 1.2)
            // right vector is [1,0,0]  (1st column)
            // lookAt vector is [0,0,1] (3d column)
            // leave the up vector unchanged (2nd column)
            // notice the increment in i in the first cycle (i+=2)
            for(int i=0; i<3; i+=2 ) 
                for(int j=0; j<3; j++ ) {
                    if ( i==j )
                        modelview.put(i*4+j, 1.0f);
                    else
                        modelview.put(i*4+j, 0.0f);
                }

            // set the modelview matrix
            GL11.glLoadMatrix(modelview);

            // draw a quad textured to match the sprite
            GL11.glBegin(GL11.GL_QUADS);
                GL11.glTexCoord2f(0,0);                                     GL11.glVertex3f( - (sprWidth/2), (sprHeight/2), 0);    // Top left Of The Quad (Left)
                GL11.glTexCoord2f(texture.getWidth(), 0);                   GL11.glVertex3f( + (sprWidth/2), (sprHeight/2), 0);  // Top right Of The Quad (Left)
                GL11.glTexCoord2f(texture.getWidth(), texture.getHeight()); GL11.glVertex3f( + (sprWidth/2), -(sprHeight/2), 0);   // Bottom right Of The Quad (Left)
                GL11.glTexCoord2f(0, texture.getHeight());                  GL11.glVertex3f( - (sprWidth/2), -(sprHeight/2), 0);   // Bottom left Of The Quad (Left)
            GL11.glEnd();

        // restore the model view matrix to prevent contamination
        GL11.glPopMatrix();
    }