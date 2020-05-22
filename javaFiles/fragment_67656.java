new ByteBuddy()
  .subclass(Exception.class)
  .defineMethod("issueType", void.class, Ownership.STATIC, Visibility.PUBLIC)
  .withParameters(Exception.class)
  .intercept(MethodCall.invoke(Crashalytics.getMethod("logException"))
                       .withArgument(0));