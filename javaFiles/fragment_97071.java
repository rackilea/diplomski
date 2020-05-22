import org.objectweb.asm.Type;

...

Type parameterAsmType = Type.getType(parameterType);
int opcode = parameterAsmType.getOpcode(Opcodes.ILOAD);
mv.visitVarInsn(opcode, 1);