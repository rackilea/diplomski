new Thread(new Runnable() {
    @Override
    public void run() {
        while(!glfwWindowShouldClose()) {
            ball.move();
            try {
                Thread.sleep(1000/fps);
            } catch(Exception e) {}
        }
    }
}).start();

while(!glfwWindowShouldClose()) {
    glfwPollEvents();
    glClear(GL_COLOR_BUFFER_BIT);

    render();

    glfwSwapBuffers(window);
}