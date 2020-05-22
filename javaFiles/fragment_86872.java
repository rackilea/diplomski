/**
 * Construct a javassist CtClass from an application class.
 */
public CtClass makeClass(ApplicationClass applicationClass) throws IOException {
    return classPool.makeClass(new ByteArrayInputStream(applicationClass.enhancedByteCode));
}