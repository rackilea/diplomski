final String junkChars = new String(new char[] {
    KeyEvent.VK_BACK_SPACE,
    KeyEvent.VK_DELETE,
    KeyEvent.VK_END,
    KeyEvent.VK_HOME
    /* The last three seem unused in the latest version
    KeyEvent.VK_PAGE_UP,
    KeyEvent.VK_PAGE_DOWN,
    KeyEvent.VK_INSERT */
});
if(!Character.isDigit(c) && junkChars.indexOf(c) == -1) {
   evt.consume();
   return false;
}  else {
    return true;
}