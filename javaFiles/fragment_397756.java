String name = "com/stackoverflow/Test.class";
byte[] bytes = // read bytes of the classfile from disk

ClassReader cr = new ClassReader(bytes);
ClassWriter cw = new ClassWriter(cr, 0);
ClassVisitor cv = new CodeLocationClassAdapter(cw);

cr.accept(cv, 0);

// write modified class file
OutputStream out = new FileOutputStream(name);
out.write(cw.toByteArray());
out.close();