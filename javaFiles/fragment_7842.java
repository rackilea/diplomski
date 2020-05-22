public static void drawLetter(Character c, Vector2D pos, Vector2D dim)
    {
        if(fontSheet == null)
            return;

        Vector2D letterPos = getPosOfLetterOnImg(c,2);

        //BufferedImage letterImage = fontSheet.getSubimage(letterPos.x, letterPos.y, FONT_WIDTH, FONT_HEIGHT);
        //int textureID = TextureLoader.loadGLTexture(letterImage);
        //letterImage = null;

        int width = fontSheet.getWidth(); int height = fontSheet.getHeight();
        double d[] = {(double)letterPos.x/width, (double)letterPos.y/height, (double)(letterPos.x+FONT_WIDTH)/width, (double)(letterPos.y+FONT_HEIGHT)/height};
        GL11.glPushMatrix();
            GL11.glTranslatef(pos.x, pos.y, 0);
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, textureID);
            GL11.glBegin(GL11.GL_QUADS);
            {
                GL11.glTexCoord2d(d[0], d[1]);
                GL11.glVertex2f(0, 0);

                GL11.glTexCoord2d(d[2], d[1]);
                GL11.glVertex2f(dim.x, 0);

                GL11.glTexCoord2d(d[2], d[3]);
                GL11.glVertex2f(dim.x, dim.y);

                GL11.glTexCoord2d(d[0], d[3]);
                GL11.glVertex2f(0, dim.y);
            }
            GL11.glEnd();
        GL11.glPopMatrix();

        //GL11.glDeleteTextures(textureID);
    }