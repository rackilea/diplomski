// Initialize your projection matrix - current number are half the dimensions for the G1 I borrowed(320x480)
glMatrixMode(GL_PROJECTION);
glLoadIdentity();
glOrthof(-240.0f, 240.0f, -160.0f, 160.0f, -1.0f, 1.0f);

// Rotate everything by 90 degrees
glMatrixMode(GL_MODELVIEW);
glLoadIdentity();
glRotatef(-90.0f, 0.0f, 1.0f, 0.0f);