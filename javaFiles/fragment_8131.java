public void keyPressed(KeyEvent k){
    int x = k.getKeyCode();
    if(x==KeyEvent.VK_SHIFT)
        showStatus("You pressed Shift Key");
    else if (x==KeyEvent.VK_ALT)
        showStatus("You pressed Alt Key");
    else
      str += k.getKeyChar(); // Add the pressed key to the string.
}