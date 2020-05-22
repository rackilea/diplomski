InputStream in = new FileInputStream("D:/ziptest/expansion1.MPQ");
OutputStream out = new GZIPOutputStream(
            new BufferedOutputStream(new FileOutputStream("test.gz")));

byte[] bytes = new byte[32*1024];
int len;
while((len = in.read(bytes)) > 0)
   out.write(bytes, 0, len);

in.close();
out.close();