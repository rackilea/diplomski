@Override
public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined,
        ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
    byte[] byteCode = classfileBuffer;

    String finalTargetClassName = this.targetClassName.replaceAll("\\.", "/");
    if (!className.equals(finalTargetClassName)) {
        return byteCode;
    }

    if (className.equals(finalTargetClassName) && loader.equals(targetClassLoader)) {
        System.out.println("[Agent] Transforming class TestApplication");
        try {
            // Step 1 Preparation
            ClassPool cp = ClassPool.getDefault();
            CtClass cc = cp.get(targetClassName);
            CtMethod m = cc.getDeclaredMethod(targetMethodName);

            // Step 2 Declare variables
            m.addLocalVariable("startTime", CtClass.longType);
            m.addLocalVariable("endTime", CtClass.longType);
            m.addLocalVariable("opTime", CtClass.longType);

            // Step 3 Insertion of extra logics/implementation
            m.insertBefore("startTime = System.currentTimeMillis();");

            m.insertAt(32,"System.out.println(\"-- This is line separator --\");");

            StringBuilder endBlock = new StringBuilder();

            endBlock.append("endTime = System.currentTimeMillis();");
            endBlock.append("opTime = (endTime-startTime)/1000;");
            endBlock.append("System.out.println(\"[Application] Withdrawal operation completed in:\" + opTime + \" seconds!\");");

            m.insertAfter(endBlock.toString());

            // Step 4 Detach from ClassPool and clean up stuff
            byteCode = cc.toBytecode();
            cc.detach();
        } catch (NotFoundException | CannotCompileException | IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    return byteCode;
}