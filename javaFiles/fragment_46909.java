final InputStream in = new BufferedInputStream(new FileInputStream("file.txt"));
final long start = System.currentTimeMillis();
int cnt = 0;
final byte[] buf = new byte[1000];
while (in.read(buf) != -1) cnt++;
in.close();
System.out.println("Elapsed " + (System.currentTimeMillis() - start) + " ms");