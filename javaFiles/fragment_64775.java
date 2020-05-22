class DelegateExtractor extends ClassFileLocator.AgentBased {

  private final ClassLoader classLoader;
  private final Instrumentation instrumentation;

  public DelegateExtractor(ClassLoader classLoader, Instrumentation instrumentation) {
    super(classLoader, instrumentation);
    this.classLoader = classLoader;
    this.instrumentation = instrumentation;
  }

  @Override
  public Resolution locate(String typeName) {
    try {
      ExtractionClassFileTransformer classFileTransformer = 
          new ExtractionClassFileTransformer(classLoader, typeName);
      try {
        instrumentation.addTransformer(classFileTransformer, true);
        // Start nasty hack
        Field field = ClassLoader.class.getDeclaredField("classes");
        field.setAccessible(true);
        instrumentation.retransformClasses(
            (Class<?>) ((Vector<?>) field.get(classLoader)).get(0));
        // End nasty hack
        byte[] binaryRepresentation = classFileTransformer.getBinaryRepresentation();
        return binaryRepresentation == null
          ? Resolution.Illegal.INSTANCE
          : new Resolution.Explicit(binaryRepresentation);
      } finally {
        instrumentation.removeTransformer(classFileTransformer);
      }
    } catch (Exception ignored) {
      return Resolution.Illegal.INSTANCE;
    }
  }
}