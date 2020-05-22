List<InsnList> l = Lists.newList();
InsnList il = new InsnList();
for (AbstractInsnNode ain : method.instructions.toArray()) {
    if (ain.getType == AbstractInsnNode.FRAME){
        l.add(il);
        il = new InsnList();
    } else {
        il.add(ain);
    }
}