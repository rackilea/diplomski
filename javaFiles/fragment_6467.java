class Foo {
    private Cache _cache;

    public Foo( Cache cache ) {
      _cache = cache;
    }

    public Foo() {
      this( new Cache() );
    }
}