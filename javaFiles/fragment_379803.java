ClassParser cp = new ClassParser("TestClass.class");
    JavaClass jc = cp.parse();
    ConstantPool constantPool = jc.getConstantPool(); // Get the constant pool here.
    for (Constant c : constantPool.getConstantPool()) {
        System.out.println(c); // Do what you need to do with all the constants.
    }