private final DependencyDetector dependencies = new DependencyDetector();
private final Map<String, byte[]> declaredClasses = new HashMap<String, byte[]>();

private byte[] getBytecode(String binaryName) {
    byte[] bytecode = declaredClasses.get(binaryName);
    if (bytecode == null) {
        // asBytes loads the class as byte[]
        bytecode =
            asBytes(binaryName.replace('.', '/') + ".class");
    }
    return bytecode;
}