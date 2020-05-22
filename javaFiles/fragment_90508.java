public class Transformer implements ClassFileTransformer {

    @Override
    public byte[] transform ( ClassLoader loader, 
        String className, Class<?> classBeingRedefined,
            ProtectionDomain protectionDomain, byte[] classfileBuffer )
            throws IllegalClassFormatException {

        if ( className.startsWith ( "phil/agent" ) ) {
            return classfileBuffer;
        }

        byte[] result = classfileBuffer;
        ClassReader reader = new ClassReader ( classfileBuffer );
        MaxStackClassVisitor maxCv = new MaxStackClassVisitor ( null );
        reader.accept ( maxCv, ClassReader.SKIP_DEBUG );

        ClassWriter writer = new ClassWriter ( ClassWriter.COMPUTE_FRAMES );
        ClassVisitor visitor = 
            new CallStackClassVisitor ( writer, maxCv.frameMap, className );
        reader.accept ( visitor, ClassReader.SKIP_DEBUG );
        result = writer.toByteArray ();
        return result;
    }
}