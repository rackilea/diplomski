while(!GLFW.glfwWindowShouldClose(window)) {
    update();
    engine.frame();
    GLFW.glfwSwapBuffers(window);
    GLFW.glfwPollEvents();
}