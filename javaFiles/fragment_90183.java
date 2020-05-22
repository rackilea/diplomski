ByteArrayOutputStream bos = new ByteArrayOutputStream();
PrintStream ps = new PrintStream(bos, false);
contentPage(ps);
ps.close();
byte[] data = bos.toByteArray();

OutputStream out = socket.getOutputStream();
out.write(data);

br.write("Content Page: : : " + new String(data));