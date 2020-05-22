Class<?> type = new ByteBuddy()
  .redefine(Foo.class)
  .name("Foo$Copy1")
  .make()
  .load(Foo.class.getClassLoader())
  .getLoaded();

Method method = type.getDeclaredMethod("increment", int.class);
int result = (Integer) method.invoke(type.newInstance(), 1);