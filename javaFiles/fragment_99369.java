glViewport(0, 0, width, height);
glMatrixMode(GL_PROJECTION);
glLoadIdentity();
if( origin_lower_left ) {
    glOrtho(0, width, height, 0, -1, 1);
} else {
    glOrtho(0, width, 0, height, -1, 1);
}
glMatrixMode(GL_MODELVIEW);
glLoadIdentity();