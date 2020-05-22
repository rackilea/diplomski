class JavaAgent {
    private JavaAgent() {}

    public static void premain(String agentArgs, Instrumentation inst) {
        System.out.println("Agent Premain Start");
        Transformer.instrumentation = inst;
        inst.addTransformer(new Transformer(), inst.isRetransformClassesSupported());
    }    
}