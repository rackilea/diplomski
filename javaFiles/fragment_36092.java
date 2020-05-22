public void draw()
    {
        glPushMatrix();
        imageData.getTexture().bind();
        int tx = (int)location.x;
        int ty = (int)location.y;
        glTranslatef(tx, ty, location.layer);

        float height = imageData.getTexture().getHeight();
        float width = imageData.getTexture().getWidth();

        float texture_X = ((float)which_column/(float)columns)*width;
        float texture_Y = ((float)which_row/(float)rows)*height;
        float texture_XplusWidth = ((float)(which_column+wide)/(float)columns)*width;
        float texture_YplusHeight = ((float)(which_row+tall)/(float)rows)*height;

        glBegin(GL_QUADS);
        {
            glTexCoord2f(texture_X, texture_Y);
            glVertex2f(0, 0);

            glTexCoord2f(texture_X, texture_YplusHeight);
            glVertex2f(0, getHeight());

            glTexCoord2f(texture_XplusWidth, texture_YplusHeight);
            glVertex2f(getWidth(), getHeight());

            glTexCoord2f(texture_XplusWidth, texture_Y);
            glVertex2f(getWidth(), 0);
        }
        glEnd();
        glPopMatrix();
    }