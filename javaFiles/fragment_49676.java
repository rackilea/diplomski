float pos[] = {-2.0f, 2.0f, -3.0f, 1.0f };
gl.glLightfv(GL.GL_LIGHT0, GL.GL_POSITION, pos, 0);
float dif[] = {1.0f,1.0f,1.0f,1.0f};
gl.glLightfv(GL.GL_LIGHT0, GL.GL_DIFFUSE, dif, 0);
float amb[] = {0.2f,0.2f, 0.2f, 1.0f};
gl.glLightfv(GL.GL_LIGHT0, GL.GL_AMBIENT, amb, 0);