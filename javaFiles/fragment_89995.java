glBegin(GL_TRIANGLE_STRIP);         // EARTH
    glNormal3f(0.0f, 0.0f, 1.0f);
    glTexCoord2d(0.5, 1.0); glVertex3f(x+size, y+size, 0.0f); // Top Right
    glTexCoord2d(0, 1.0); glVertex3f(x-size, y+size, 0.0f); // Top Left
    glTexCoord2d(0.5, 0.5); glVertex3f(x+size, y-size, 0.0f); // Bottom Right
    glTexCoord2d(0, 0.5); glVertex3f(x-size, y-size, 0.0f); // Bottom Left
glEnd();