public class FindUsageTransformer implements ClassFileTransformer{

        Class clazz = null;
        public byte[] transform(ClassLoader loader,String className,Class<?>  classBeingRedefined,  ProtectionDomain    protectionDomain,
                byte[]              classfileBuffer)    throws IllegalClassFormatException {
            if(className.equals("A")){
                doClass(className, classBeingRedefined, classfileBuffer);
            }
            return classfileBuffer;
        }
        private byte[] doClass(String name, Class clazz, byte[] b) {
            ClassPool pool = ClassPool.getDefault();
            CtClass cl = null;
            try {
              cl = pool.makeClass(new java.io.ByteArrayInputStream(b));
              CtMethod method =  cl.getDeclaredMethod("getA2");
              // here you have lot of options to explore
              method.insertBefore("System.out.println(Thread.currentThread().getStackTrace()[0].getClassName()+ Thread.currentThread().getStackTrace()[0].getMethodName());");
              b = cl.toBytecode();
            } catch (Exception e) {
              System.err.println("Could not instrument  " + name
                  + ",  exception : " + e.getMessage());
            } finally {
              if (cl != null) {
                cl.detach();
              }
            }
            return b;
          }