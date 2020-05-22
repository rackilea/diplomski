glPushMatrix();
glDisable(GL_DEPTH_TEST);
glDisable(GL_BLEND);
glCallList(selectionDisplayList);
glEnable(GL_DEPTH_TEST);
glEnable(GL_BLEND);
glPopMatrix();