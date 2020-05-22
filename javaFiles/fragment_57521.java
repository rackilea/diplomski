public void render() {
    glClearColor(0, 0, 0, 0);
    glClear(GL_COLOR_BUFFER_BIT);

    glLoadIdentity();
    // Coordinate system starts out as screen space coordinates
    glOrtho(0, 400, 300, 0, 1, -1);
    glColor3d(1, 0.5, 0.5);
    renderCircle(120, 120, 100);
    glColor3d(0.5, 1, 0.5);
    renderCircle(300, 200, 50);
    glColor3d(0.5, 0.5, 1);
    renderCircle(200, 250, 30);
}

private void renderCircle(double centerX, double centerY, double radius) {
    glPushMatrix();
    glTranslated(centerX, centerY, 0);
    glScaled(radius, radius, 1);
    // Another translation here would be wrong
    renderUnitCircle();
    glPopMatrix();
}

private void renderUnitCircle() {
    glBegin(GL_TRIANGLE_FAN);
    int numVertices = 100;
    double angle = 2 * Math.PI / numVertices;
    for (int i = 0; i < numVertices; ++i) {
        glVertex2d(Math.cos(i*angle), Math.sin(i*angle));
    }
    glEnd();
}