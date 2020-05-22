new ByteBuddy()
  .subclass(UserPojo.class)
  .method(ElementMatchers.isSetter())
  .intercept(MethodDelegation.to(MyInterceptor.class)
             .andThen(SuperMethodCall.INSTANCE)
  .make();