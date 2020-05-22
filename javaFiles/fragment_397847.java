GLFWVidMode vidmode = glfwGetVideoMode(glfwGetPrimaryMonitor());

    glfwSetWindowPos(
            window,
             (vidmode.width() - width) / 2,
            (vidmode.height() - height) / 2
        );