push(key.length);
newArray(Type.BYTE_TYPE);
for(int i = 0; i < key.length; i++) {
    this.visitInsn(Opcodes.DUP);
    push(i);
    push(key[i]);
    visitInsn(Opcodes.BASTORE);
}