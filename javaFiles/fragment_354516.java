FileInputStream fdIn = new FileInputStream(FileDescriptor.in);
FileOutputStream fdOut = new FileOutputStream(FileDescriptor.out);
FileOutputStream fdErr = new FileOutputStream(FileDescriptor.err);
setIn0(new BufferedInputStream(fdIn));
setOut0(new PrintStream(new BufferedOutputStream(fdOut, 128), true));
setErr0(new PrintStream(new BufferedOutputStream(fdErr, 128), true));