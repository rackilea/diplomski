// (double) buffering
gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
gl.glClear(gl.GL_COLOR_BUFFER_BIT | gl.GL_DEPTH_BUFFER_BIT); // non eed for the depth although
// here set matrices in case they are not persistent
gl.glMatrixMode(gl.GL_MODELVIEW);
gl.glLoadIdentity();
gl.glMatrixMode(gl.GL_PROJECTION);
gl.glLoadIdentity();
// here set/reset config the pipeline
gl.glDisable(gl.GL_DEPTH_TEST);
gl.glDisable(gl.GL_TEXTURE_2D);
gl.glLineWidth(1.0);
// here render
double x;
gl.glColor3d(0.0, 0.0, 0.0);
gl.glBegin(gl.GL_LINE_STRIP);
for (x=-180.0;x=<180.0;x+=0.01)
 gl.glVertex2d(x/180.0, Math.sin(Math.toRadians(x)));
gl.glEnd();
// (double) buffering
gl.glFlush();
SwapBuffers(hdc);