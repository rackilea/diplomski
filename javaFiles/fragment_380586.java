long window = GLFW.glfwCreateWindow(640, 480, "Hello World", 0, 0);
if(window == 0){
    throw new IllegalStateException("Failed to create Window");
}

GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());
glfwSetWindowPos(window, (vidmode.width() - 640) / 2, (vidmode.height() - 480) / 2);

glfwMakeContextCurrent(window);  // <-----

glfwShowWindow(window);

GL.createCapabilities();         // <-----

.....