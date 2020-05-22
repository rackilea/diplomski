FileOutputStream fout = new FileOutputStream("c:/tmp/foo.jar");
JarOutputStream jarOut = new JarOutputStream(fout);
jarOut.putNextEntry(new ZipEntry("com/foo/")); // Folders must end with "/".
jarOut.putNextEntry(new ZipEntry("com/foo/Foo.class"));
jarOut.write(getBytes("com/foo/Foo.class"));
jarOut.closeEntry();
jarOut.putNextEntry(new ZipEntry("com/foo/Bar.class"));
jarOut.write(getBytes("com/foo/Bar.class"));
jarOut.closeEntry();
jarOut.close();
fout.close();