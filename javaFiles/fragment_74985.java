class FieldAnnotationScanner extends FieldVisitor {
    public FieldAnnotationScanner() {
        super(Opcodes.ASM5);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        System.out.println("visitAnnotation: desc="+desc+" visible="+visible);
        return super.visitAnnotation(desc, visible);
    }
}

class MethodAnnotationScanner extends MethodVisitor {
    public MethodAnnotationScanner() {
        super(Opcodes.ASM5);
    }

    @Override
    public AnnotationVisitor visitAnnotation(String desc, boolean visible) {
        System.out.println("visitAnnotation: desc="+desc+" visible="+visible);
        return super.visitAnnotation(desc, visible);
    }
}