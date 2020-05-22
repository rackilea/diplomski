if (foo instanceof FooSubclass) {
  FooSubclass fooSub = (FooSubclass) foo;
  //foo and fooSub now are references to the same object, and you can use fooSub to call methods on the subclass
} else if (foo instanceof OtherSubclass) {
  OtherSubclass otherSub = (OtherSubclass) foo;
  //you can now use otherSub to call subclass-specific methods on foo
}