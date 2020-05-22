while(!glfwWindowShouldClose()) {
    glfwPollEvents();
    glClear(GL_COLOR_BUFFER_BIT);

    ball.move();
    render();

    glfwSwapBuffers(window);
}