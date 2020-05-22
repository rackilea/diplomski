glMatrixMode(GL_PROJECTION);
glLoadIdentity();
glOrtho(0.0, windowWidth, windowHeight, 0.0, -1.0, 1.0);

glMatrixMode(GL_MODELVIEW);

while (!glfwWindowShouldClose(window))
{
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);


    // [...]
}