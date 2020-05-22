public class MyAgent {
        public static void premain(String agentArguments, Instrumentation instrumentation) {
            instrumentation.addTransformer(new ClassFileTransformer() {

                @Override
                public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer)
                    throws IllegalClassFormatException {
                    if (className.equals("org/victim/PrivateClass")) { //name of class you want to modify
                        try {
                            ClassReader cr = new ClassReader(classfileBuffer);
                            ClassNode cn = new ClassNode();
                            cr.accept(cn, 0);

                            for (Object methodInst : cn.methods) {
                                MethodNode method = (MethodNode) methodInst;
                                if (method.name.equals("<init>") && method.desc.equals("()V")) { //we get constructor with no arguments, you can filter whatever you want
                                    method.access &= ~Opcodes.ACC_PRIVATE;
                                    method.access |= Opcodes.ACC_PUBLIC; //removed "private" flag, set "public" flag
                                }
                            }
                            ClassWriter result = new ClassWriter(0);
                            cn.accept(result);
                            return result.toByteArray();
                        } catch (Throwable e) {
                            return null; //or you can somehow log failure here
                        }
                    }
                    return null;
                }
            });
        }
    }