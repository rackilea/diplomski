MethodNode method = new MethodNode(ASM6, 0, methodName, methodDesc, null, null);
method.access = ACC_PUBLIC | ACC_STATIC;
method.annotationDefault = Integer.MIN_VALUE; // see notes
AbstractInsnNode invokeStringLength =
    new MethodInsnNode(INVOKEVIRTUAL, "java/lang/String", "length", "()I", false);
method.instructions.add(new IntInsnNode(ALOAD, 0)); // push String method arg
method.instructions.add(invokeStringLength);        // invoke .length()
method.instructions.add(new InsnNode(IRETURN));     // return an int value
method.maxLocals = 1;
method.maxStack = 1;
cn.methods.add(method);