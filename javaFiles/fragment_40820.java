classReader.accept(new ClassVisitor(Opcodes.ASM5) {
    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        return new MyMethodVisitor(access, desc);
    }
}, ClassReader.EXPAND_FRAMES);