byte[] buffer = new byte[16384];
InputStream in = new FileInputStream(src);
OutputStream out = new FileOutputStream(dst);
while (true) {
int n = in.read(buffer);
if (n == -1)
break;
out.write(buffer, 0, n);
}
in.close();
out.close();