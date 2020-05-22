public class MyEntity {
  private final TreeSet<MyEntity> container;

  ...

  public void setName(final String name) {
    container.remove(this);
    this.name = name;
    container.add(this);
  }
}