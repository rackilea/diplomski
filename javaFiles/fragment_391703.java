public enum X implements Y {
  A (Ybuilder.create(0)),
  B (Ybuilder.create(1));
  private final Y y;
  X(Y y) { this.y = y; }
};