//ENABLE THESE:

glEnable(GL_BLEND);
glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);


//RENDER LIKE THIS:

glPushMatrix(); 
bodyPosition = body.getPosition().mul(30);
glTranslatef(Position.x, Position.y, 0);
GL11.glDisable(GL11.GL_TEXTURE_2D);
glPopMatrix();