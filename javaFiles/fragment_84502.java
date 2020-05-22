public static void premain(String agentArgument, Instrumentation instrumentation) {
    System.out.println(">>>>>>>>>>>>>>>>>> Entered premain");
    try {
        new AgentBuilder.Default()
                .type(ElementMatchers.nameStartsWith("com.mycomp.hikari.LoggingPreparedStatement"))
                .transform((builder, typeDescription, classLoader) -> builder
                        .method(ElementMatchers.any())
                        .intercept(MethodDelegation.to(new Interceptor())))
                .installOn(instrumentation);
    } catch (RuntimeException e) {
        System.out.println(">>>>>>>>>>>>>>>>>> Exception instrumenting code : " + e);
        e.printStackTrace();
    }
}