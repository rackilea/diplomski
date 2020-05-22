DirtyClass d = new ByteBuddy()
  .subclass(DirtyClass.class)
  .method(isSetter().and(not(named("setDirty"))))
  .intercept(SuperMethodCall.INSTANCE.andThen(
      MethodCall.invoke(DirtyClass.class.getMethod("setDirty", boolean.class))
                .with(true)
  )).make()
  .load(DirtyClass.class.getClassLoader())
  .getLoaded()
  .newInstance();