new AgentBuilder.Default()
  .enableNativeMethodPrefix("foo")
  .type(named("test.ClassWithNatives"))
  .transform((b,t,c,m) -> b
    .method(named("someNativeMethod"))
    .intercept(MethodDelegation.to(NativeInterceptor.class))
  ).installOn(inst);