GLFWCursorPosCallback cursorPosCallback = new GLFWCursorPosCallback() {
    @Override
    public void invoke(long window, double xpos, double ypos) {
        // ...
    }
};
glfwSetCursorPosCallback(windowId, cursorPosCallback);