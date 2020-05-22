public class Whatever {
  private final Foo theFoo;

  public Whatever(Foo theFoo) {
   Objects.requireNonNull(theFoo, "theFoo must not be null");
   this.theFoo = theFoo;