//Output from this can be properly unpacked with command line tool
InputStream in = new GZIPInputStream(new ByteArrayInputStream(compressed));

//This is where things go awry
Pack200.Unpacker unpacker = Pack200.newUnpacker();
JarOutputStream out = new JarOutputStream(new FileOutputStream("file.jar"));
unpacker.unpack(in, out);
out.close();