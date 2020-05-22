while(!glfwWindowShouldClose(window)){
    renderer.prepare();
    renderer.render(model);

    glfwSwapBuffers(window); // <-----

    glfwPollEvents();
}