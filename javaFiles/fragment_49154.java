try(FileInputStream in = new FileInputStream(new File("input.class")) {
    ClassReader classReader = new ClassReader(in);
    ClassWriter classWriter = new ClassWriter(classReader, 0);
    classReader.accept(classWriter, 0);
    Files.write(Paths.get("output.class"), classWriter.toByteArray());
}