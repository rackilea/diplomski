public static void square(int x, int y, int w, int h, byte[] rgb) {
    glDisable(GL_TEXTURE_2D);
    glColor3b(rgb[0], rgb[1], rgb[2]);
    glBegin(GL_QUADS);
    glVertex2i(x, y);
    glVertex2i(x + w, y);
    glVertex2i(x + w, y + h);
    glVertex2i(x,y+h);
    glEnd();
    glEnable(GL_TEXTURE_2D);

}