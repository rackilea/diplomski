public void stretch() {
        Color.white.bind();
        texture.bind

        GL11.glBegin(GL11.GL_QUADS);
        GL11.glTexCoord2f(0,0);
        GL11.glVertex2f(100,100);
        GL11.glTexCoord2f(1,0);
        GL11.glVertex2f(100+texture.getTextureWidth(),100);
        GL11.glTexCoord2f(1,1);
        GL11.glVertex2f(100+texture.getTextureWidth(),100+character.getTextureHeight());
        GL11.glTexCoord2f(0,1);
        GL11.glVertex2f(100,100+texture.getTextureHeight());

        GL11.glEnd(); // all the 0's were originally 100 but it was off centered
    }

texture = TextureLoader.getTexture("PNG",ResourceLoader.getResourceAsStream("res/texture.png"));