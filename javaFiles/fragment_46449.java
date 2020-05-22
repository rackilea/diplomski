public static void main(String[] args)  {

    ClassPool pool = ClassPool.getDefault();

    try {
        CtClass cc = pool.get("java.lang.String");
        byte[] bytes = cc.toBytecode();

        System.out.println("Bytecode start");
        for (Byte b : bytes) {
            System.out.println(b);
        }
        System.out.println("Bytecode end");

    } catch (NotFoundException e) {
        e.printStackTrace();
    } catch (CannotCompileException e) {
        e.printStackTrace();
    }

}