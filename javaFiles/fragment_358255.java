@Provides
@Foo int providesFoo() {
  return getNativeFoo();
}

// Use JSNI to get the global Javascript variable.
private static native int getNativeFoo() /*-{
  return globalFoo;
}-*/;