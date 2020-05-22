private static void instrument(String agentOps, Instrumentation inst) {
    new AgentBuilder.Default()
        .with(new Eager())
        .type((any()))
        .transform((builder, typeDescription, classLoader, module) ->
            builder
                .method(any())
                .intercept(Advice.to(LoggingAdvice.class)))
        .installOn(inst);
  }