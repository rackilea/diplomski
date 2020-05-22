clazz = fullclass name, method = "public void doxxx(){ int x =0;x++}"

private static void createMethod(String clazz,String method){
        ClassPool pool = ClassPool.getDefault();
        try {
            Class<?> class1 =  Class.forName(clazz);
            class1.getProtectionDomain().getCodeSource().getLocation();
            pool.insertClassPath(new ClassClassPath(class1));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        CtClass pt;
        try {

            pt = pool.get(clazz);



            CtMethod m = CtNewMethod.make(method, pt);
            pt.addMethod(m);
            pt.writeFile();
            pt.toClass();

        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (CannotCompileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }