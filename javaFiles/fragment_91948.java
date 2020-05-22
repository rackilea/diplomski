package com.busytrack.discographymanager.headerfixagent;
import java.io.ByteArrayInputStream;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

public class ClassTransformer implements ClassFileTransformer {
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        byte[] byteCode = classfileBuffer;
        if (className.equals("com/sun/webkit/network/URLLoader")) {
            try {
                ClassPool classPool = new ClassPool(true);
                CtClass ctClass = classPool.makeClass(new ByteArrayInputStream(classfileBuffer));
                CtMethod method = ctClass.getDeclaredMethod("prepareConnection");
                String src = "$1.setRequestProperty(\"Referer\", \"https://www.discogs.com\");"; // Confused about there being "$1" instead of "c"? Please read below
                method.insertBefore(src);
                byteCode = ctClass.toBytecode();
                ctClass.detach();
            }  catch (Exception e) {
                e.printStackTrace();
            }
        }   
        return byteCode;
    }
}