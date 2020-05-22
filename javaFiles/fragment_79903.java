GL11.glTranslated(ep.posX - RenderManager.renderPosX, ep.posY - RenderManager.renderPosY, ep.posZ - RenderManager.renderPosZ );
GL11.glBegin(GL11.GL_TRIANGLES);
GL11.glVertex3d(0, ep.height + 0.5D, 0);
GL11.glVertex3d(1, 0, 0);
GL11.glVertex3d(0, 0, 1);
GL11.glEnd();