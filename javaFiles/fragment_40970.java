abstract class Toy {
  abstract Color getActualColor();
}

class Bike {
  @Override Color getActualColor() { return getFrameColor(); }
}

class Skateboard {
  @Override Color getActualColor() { return getColor(); }
}

...
toys.stream().map(Toy::getActualColor).collect(Collectors.toSet());