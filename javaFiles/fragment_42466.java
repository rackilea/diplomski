public class Transformer implements ClassFileTransformer {
    public static Set<Class<?>> transformMe = new Set<>()
    public static Instrumentation instrumentation = null; // set during premain()
    @Override
    public byte[] transform(ClassLoader loader,
                            String className,
                            Class<?> classBeingRedefined,
                            ProtectionDomain protectionDomain,
                            byte[] origBytes) {


        if (transformMe.contains(classBeingRedefined)) {
            return instrument(origBytes, loader);
        } else {
            return null;
        }
    }
    public byte[] instrument(byte[] origBytes) {
        // magic happens here
    }
}