void copy_buffer()
{
  static GLint viewport[4];
  static GLfloat raster_pos[4];

  glGetIntegerv(GL_VIEWPORT, viewport);

  /* set source buffer */
  glReadBuffer(GL_FRONT);

  /* set projection matrix */
  glMatrixMode(GL_PROJECTION);
  glPushMatrix();
  glLoadIdentity() ;
  gluOrtho2D(0, viewport[2], 0, viewport[3]);

  /* set modelview matrix */
  glMatrixMode(GL_MODELVIEW);
  glPushMatrix();
  glLoadIdentity();

  /* save old raster position */
  glGetFloatv(GL_CURRENT_RASTER_POSITION, raster_pos);

  /* set raster position */
  glRasterPos4f(0.0, 0.0, 0.0, 1.0);

  /* copy buffer */
  glCopyPixels(0, 0, viewport[2], viewport[3], GL_COLOR);

  /* restore old raster position */
  glRasterPos4fv(raster_pos);

  /* restore old matrices */
  glPopMatrix();
  glMatrixMode(GL_PROJECTION);
  glPopMatrix();
  glMatrixMode(GL_MODELVIEW);

  /* restore source buffer */
  glReadBuffer(GL_BACK); 
}