GL11.glBindTexture(GL11.GL_TEXTURE_2D, skybox.getTextureID());
GL11.glBegin(GL11.GL_QUADS);
    //Front Face
    GL11.glTexCoord2f(0.25f, 0.25f);
    GL11.glVertex3f(-player.x - offset, -player.y - offset, -player.z - offset);
    GL11.glTexCoord2f(0.25f, 0.5f);
    GL11.glVertex3f(-player.x - offset, -player.y + offset, -player.z - offset);
    GL11.glTexCoord2f(0.0f, 0.5f);
    GL11.glVertex3f(-player.x + offset, -player.y + offset, -player.z - offset);
    GL11.glTexCoord2f(0.0f, 0.25f);
    GL11.glVertex3f(-player.x + offset, -player.y - offset, -player.z - offset);

    // Back Face
    ...
GL11.glEnd();