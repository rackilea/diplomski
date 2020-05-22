public static void updateViewPort() {
    IntBuffer pWidth = stack.mallocInt(1);
    IntBuffer pHeight = stack.mallocInt(1);

    GLFW.glfwGetFramebufferSize(WINDOW, pWidth, pHeight);
    GL11.glViewport(0, 0, pWidth.get(0), pHeight.get(0)); 
}