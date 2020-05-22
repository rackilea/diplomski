Class<? extends Exception> dynamicType = new ByteBuddy()
  .subclass(Exception.class)
  .name(issueType)
  .make()
  .load(Fabric.class.getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
  .getLoaded();

 Exception e = dynamicType.getConstructor(String.class).newInstance(errorMsg);