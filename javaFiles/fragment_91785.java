package org.objectweb.asm;

import java.util.HashMap;
import java.util.Map;

public final class ConstantHistogrammer extends ClassVisitor {
    private final ConstantPoolSortingClassWriter cw;
    private final Map<Item, Integer> constantHistogram = new HashMap<>();
    public ConstantHistogrammer(ConstantPoolSortingClassWriter cw) {
        super(Opcodes.ASM5, cw);
        this.cw = cw;
    }
    @Override
    public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
        return new CollectLDC(super.visitMethod(access, name, desc, signature, exceptions));
    }
    @Override
    public void visitEnd() {
        cw.constantHistogram = constantHistogram;
        super.visitEnd();
    }
    private final class CollectLDC extends MethodVisitor {
        private CollectLDC(MethodVisitor mv) {
            super(Opcodes.ASM5, mv);
        }
        @Override
        public void visitLdcInsn(Object cst) {
            //we only care about things ldc can load
            if (cst instanceof Integer || cst instanceof Float || cst instanceof String ||
                    cst instanceof Type || cst instanceof Handle)
                constantHistogram.merge(cw.newConstItem(cst), 1, Integer::sum);
            super.visitLdcInsn(cst);
        }
    }
}