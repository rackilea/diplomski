static {
  try {
    sprites.put("Tiles", getSpriteSheet("Tiles.png", 32, 32));
  } catch (SlickException e) {
    // ...
  }