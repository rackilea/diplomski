- Characters (a, A, #, ...) - handled in the keyTyped() listener.
- Virtual keys (arrow keys, function keys, etc) - handled with keyPressed() listener.
- Modifier keys (shift, alt, control, ...) - Usually their status (up/down) is tested by calls in one of the other listeners, rather than in keyPressed().

  public void keyTyped(KeyEvent e) {
    System.out.println(e.toString());
  }
  public void keyPressed(KeyEvent e) {
   System.out.println(e.toString());
  }
  public void keyReleased(KeyEvent e) {
    System.out.println(e.toString());
  }