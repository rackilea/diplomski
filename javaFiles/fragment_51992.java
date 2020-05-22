public class DynamicTransformer implements ClassFileTransformer {

    public byte[] transform(ClassLoader loader, String className, Class classBeingRedefined,
    ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {

        byte[] byteCode = classfileBuffer;

        // into the transformer will arrive every class loaded so you filter 
        // to match only what you need
        if (className.equals("com/full/path/to/be/instrumented/className1") ||
            className.equals("com/full/path/to/be/instrumented/className2") ||
            className.equals("com/full/path/to/be/instrumented/className3") ) {

            byteCode = myMethodThatTransform(className, byteCode);
        }

        return byteCode;
    }


    public byte[] myMethodThatTransform(String className, byte[] byteCode){\
        try {
            // retrive default Javassist class pool
            ClassPool cp = ClassPool.getDefault();
            // get from the class pool our class with this qualified name
            CtClass cc = cp.get(className);
            // get all the methods of the retrieved class
            CtMethod[] methods = cc.getDeclaredMethods()
            for(CtMethod meth : methods) {
                // The instrumentation code to be returned and injected
                final StringBuffer buffer = new StringBuffer();
                String name = meth.getName();
                // just print into the buffer a log for example
                buffer.append("System.out.println(\"Method " + name + " executed\" );");
                meth.insertBefore(buffer.toString())
            }
            // create the byteclode of the class
            byteCode = cc.toBytecode();
            // remove the CtClass from the ClassPool
            cc.detach();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return byteCode;
    }
}