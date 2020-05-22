File tmp = File.createTemp("prefix", ".tmp");
tmp.deleteOnExit();
InputStream is = getClass().getResourceAsStream(myDirPath + "/file1.txt");
OutputStream os = new FileOutputStream(tmp);
ByteStreams.copy(is, os);
os.close();
is.close();