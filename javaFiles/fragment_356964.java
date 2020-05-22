instrumentation.addTransformer(new ClassFileTransformer() {
  @Override
  public byte[] transform(ClassLoader loader,
                          String name,
                          Class<?> classBeingRedefined,
                          ProtectionDomain pd,
                          byte[] classFileBuffer) {
    doSomethingWith(classFileBuffer);
    return null;
  }
}, true);