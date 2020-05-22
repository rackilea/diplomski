while (!closeRequested) {
    GL11.glViewport(0, 0, dim.width, dim.height);
    Display.update();
}

//finished
Display.destroy();