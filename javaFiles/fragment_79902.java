GL11.glBegin(GL11.GL_QUADS);
GL11.glVertex3d(ep.posX - RenderManager.renderPosX, ep.posY + ep.height + 0.5D - RenderManager.renderPosY, ep.posZ - RenderManager.renderPosZ);
GL11.glVertex3d(ep.posX - RenderManager.renderPosX + 1, ep.posY - RenderManager.renderPosY, ep.posZ - RenderManager.renderPosZ);
GL11.glVertex3d(ep.posX - RenderManager.renderPosX, ep.posY - RenderManager.renderPosY, ep.posZ - RenderManager.renderPosZ + 1);
GL11.glVertex3d(ep.posX - RenderManager.renderPosX, ep.posY + ep.height + 0.5D - RenderManager.renderPosY, ep.posZ - RenderManager.renderPosZ);
GL11.glEnd();