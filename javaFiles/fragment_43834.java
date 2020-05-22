private void nameTextKeyTyped(final KeyEvent event)
{
    boolean doBeep = true;
    final char c = event.getKeyChar();
    switch (c) {
        case KeyEvent.VK_BACK_SPACE: 
        case KeyEvent.VK_DELETE:
        case KeyEvent.VK_SPACE:
            doBeep = false;
            break;
        default:
            doBeep = !Character.isAlphabetic(c);
            // no need to "break;": last branch of switch
    }
    if (doBeep)
        getToolkit.beep();
    event.consume();
}