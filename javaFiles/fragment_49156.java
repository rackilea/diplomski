try(FileInputStream in = new FileInputStream(new File("input.class"))) {
    ClassReader classReader = new ClassReader(in);
    ClassWriter classWriter = new ClassWriter(classReader, ClassWriter.COMPUTE_FRAMES);
    classReader.accept(new MyClassVisitor(classWriter), ClassReader.SKIP_FRAMES);
    Files.write(Paths.get("output.class"), classWriter.toByteArray());
}