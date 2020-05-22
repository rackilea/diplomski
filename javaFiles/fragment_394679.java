ClassVisitor visitor = new ClassVisitor(Opcodes.ASM4, writer) {
    @Override
    public MethodVisitor visitMethod(int access, final String name, String desc, String signature, String[] exceptions) {
        MethodVisitor mv = cv.visitMethod(access, name, desc, signature, exceptions);
        if (!name.contains("sayHello")) return mv;

        MethodVisitor mv2 = new MethodVisitor(Opcodes.ASM4, mv) {
            public void visitCode() {
                mv.visitMethodInsn(Opcodes.INVOKESTATIC, "traceagent/JavaTraceAgent", "logMethodInvocation", "()V");
            }
        };

        return mv2;
    }
};