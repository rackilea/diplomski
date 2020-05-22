class Foo {

  private String foo;

  String access$100() {  // synthetic method
    return foo;
  }

  Foo$Bar bar() {
    return new Foo$Bar(this, (Foo$1)null);
  }

  Foo() { } // NON-synthetic, but implicit!
}

class Foo$Bar {

  private final Foo $this; // synthetic field

  private Foo$Bar(Foo $this) {  // synthetic parameter
    this.$this = $this;
  }

  Foo$Bar(Foo $this, Foo$1 unused) {  // synthetic constructor
    this($this);
  }

  String bar() {
    return $this.access$100();
  }
}

class Foo$1 { /*empty, no constructor */ } // synthetic class