public void drawLetterOnZYWall(Texture letter,zyWall wall) {


    glBindTexture(GL_TEXTURE_2D, letter.getTextureID());

    glEnable(GL_TEXTURE_2D);
    glBegin(GL_QUADS);
    glTexCoord2f(1, 0);
    glVertex3f(wall.getPosX()+0.01f, WALL_HEIGHT, wall.getPosZ());
    glTexCoord2f(0, 0);
    glVertex3f(wall.getPosX()+0.01f, WALL_HEIGHT, wall.getPosZ() + wall.getWidth()/10);
    glTexCoord2f(0, 1);
    glVertex3f(wall.getPosX()+0.01f, (float)WALL_HEIGHT*((float)8/(float)10), wall.getPosZ() + wall.getWidth()/10);
    glTexCoord2f(1, 1);
    glVertex3f(wall.getPosX()+0.01f, (float)WALL_HEIGHT*((float)8/(float)10), wall.getPosZ());

    glTexCoord2f(1, 0);
    glVertex3f(wall.getPosX()-0.01f, WALL_HEIGHT, wall.getPosZ());
    glTexCoord2f(0, 0);
    glVertex3f(wall.getPosX()-0.01f, WALL_HEIGHT, wall.getPosZ() + wall.getWidth()/10);
    glTexCoord2f(0, 1);
    glVertex3f(wall.getPosX() - 0.01f, (float)WALL_HEIGHT*((float)8/(float)10), wall.getPosZ() + wall.getWidth()/10);
    glTexCoord2f(1, 1);
    glVertex3f(wall.getPosX()-0.01f, (float)WALL_HEIGHT*((float)8/(float)10), wall.getPosZ());

    glEnd();
    glDisable(GL_TEXTURE_2D);
}