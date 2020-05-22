public class Foo {
  public List<Bar> bars = new ArrayList<Bar>();
  private String secret;

  // Copy constructor
  public Foo(Foo that) {
    // new List
    this.bars = new ArrayList<Bar>();

    // add a clone of each bar (as an example, if you need "deep cloning")
    for (Bar bar:that.bars) {
      this.bars.add(new Bar(bar));
    }

    // clone the secret value
    this.secret = new String(that.secret);
  }

  // ...

}