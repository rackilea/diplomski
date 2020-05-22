public void actionPerformed(ActionEvent e) {
  player.x += player.xVelocity;
  player.y += player.yVelocity;

  Rectangle2D offset = player.getOffsetBounds();

  if (offset.intersects(this.rectangle.wallObj.getBounds2D())) {
    collision = true;
    player.xVelocity = 0;
    player.yVelocity = 0;
  } else {
    collision = false;
  }

  repaint();
}