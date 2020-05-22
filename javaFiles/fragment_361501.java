public void keyPressed(KeyEvent e)
{
    int keyTheUserJustPressed = e.getKeyCode();

    // then use for ctrl/alt/shift
    e.getModifiersEx();

    // or use
    e.isAltDown();
    e.isShiftDown();
}