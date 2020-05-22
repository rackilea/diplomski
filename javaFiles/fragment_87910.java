/**
 * Given a map of ClassNodes and mappings, returns a map of class names to
 * class bytes.
 */
public static Map<String, byte[]> process(Map<String, ClassNode> nodes, Map<String, MappedClass> mappings) {
    Map<String, byte[]> out = new HashMap<String, byte[]>();
    RemapperImpl mapper = new RemapperImpl(mappings);
    for (ClassNode cn : nodes.values()) {
        ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_FRAMES);
        ClassVisitor remapper = new ClassRemapper(cw, mapper);
        cn.accept(remapper);
        out.put(mappings.get(cn.name).getNewName(), cw.toByteArray());
    }
    return out;
}