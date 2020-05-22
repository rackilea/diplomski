@Override
protected void Draw() {
    BufferStrategy bs = getBufferStrategy();
    Graphics g = bs.getDrawGraphics(); // acquire the graphics

    // draw stuff here

    bs.show(); // swap buffers
}