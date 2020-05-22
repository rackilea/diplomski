public final class CategoryKey {
  private final int layer;
  private final int parent;
  private final int child;

  public CategoryKey(int layer, int parent, int child) {
    this.layer = layer;
    this.parent = parent;
    this.child = child;
  }

  public int getLayer() {
    return layer;
  }

  public int getParent() {
    return parent;
  }

  public int getChild() {
    return child;
  }

  @Override public boolean equals(Object other) {
    if (!(other instanceof CategoryKey)) {
      return false;
    }
    CategoryKey otherKey = (CategoryKey) other;
    return layer == otherKey.layer
      && parent == otherKey.parent
      && child == otherKey.child;
  }

  @Override public int hashCode() {
    int hash = 23;
    hash = hash * 31 + layer;
    hash = hash * 31 + parent;
    hash = hash * 31 + child;
    return hash;
  }
}