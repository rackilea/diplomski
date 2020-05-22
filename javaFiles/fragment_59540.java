private void getInput() {
  xMove = 0;
  yMove = 0;

  if (handler.getKeyManager().up) {
      yMove = -speed;
      lastPressed = handler.getKeyManager().up;
  }
  //...
}

private BufferedImage getCurrentAnimationFrame() {
  if (handler.getKeyManager().left && lastPressed == handler.getKeyManager().left) {
    return left.getCurrentFrame();
  } else if ( !(handler.getKeyManager().left)) {
    return left_idle.getCurrentFrame();
  }
  //...
  return null;
}