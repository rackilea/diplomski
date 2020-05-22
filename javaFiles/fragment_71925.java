StringWriter sw = new StringWriter();
ClassVisitor tracer = new TraceClassVisitor(writer,new PrintWriter(sw));
ClassVisitor visitor = new YourClassVisitor(tracer, className);
ClassVisitor checker = new CheckClassAdapter(visitor, true);
cr.accept(checker, ClassReader.EXPAND_FRAMES);
System.out.println(sw.toString());