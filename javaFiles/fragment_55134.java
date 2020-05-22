double x;
gl.glColor3d(0.0, 0.0, 0.0);
gl.glBegin(gl.GL_LINE_STRIP);
for (x=-180.0;x<=180.0;x+=0.01)
 gl.glVertex2d(x/180.0, Math.sin(Math.toRadians(x)));
gl.glEnd();