Keyboard.enableRepeatEvents(false);
...
/* in your game update routine */
final int key = Keyboard.getEventKey();
final boolean pressed = Keyboard.getEventKeyState();
final Direction dir = Direction.of(key);
if (pressed) {
  movement = dir;
} else if (movement != Direction.NONE && movement == dir) {
  movement = Direction.NONE;
}
...
/* later on, use movement to determine which direction to move */