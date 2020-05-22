byte[] inputBytes = Files.readAllBytes(input);
ClassReader cr = new ClassReader(inputBytes);
ConstantPoolSortingClassWriter cw = new ConstantPoolSortingClassWriter(0);
ConstantHistogrammer ch = new ConstantHistogrammer(cw);
ClassVisitor s = new SomeOtherClassVisitor(ch);
cr.accept(s, 0);
byte[] outputBytes = cw.toByteArray();