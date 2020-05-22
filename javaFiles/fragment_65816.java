GL11.glBegin(GL11.GL_QUADS);
{
    GL11.glTexCoord2f(0, 0);   // <--
    GL11.glVertex2f(0, 0);

    GL11.glTexCoord2f(0, 1);   // <--
    GL11.glVertex2f(0, height);

    GL11.glTexCoord2f(1, 1);   // <--
    GL11.glVertex2f(width, height);

    GL11.glTexCoord2f(1, 0);   // <--
    GL11.glVertex2f(width,0);
}