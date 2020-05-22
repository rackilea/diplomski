enum Direction {
  NONE, LEFT, RIGHT, DOWN, UP;

  static Direction of(final int key) {
    switch (key) {
      case Keyboard.KEY_A:
        return Direction.LEFT;
      case Keyboard.KEY_D:
        return Direction.RIGHT;
      case Keyboard.KEY_W:
        return Direction.UP;
      case Keyboard.KEY_S:
        return Direction.DOWN;
      default:
        return Direction.NONE;
    }
  }
}