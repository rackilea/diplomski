InputStream in = connection.getInputStream();
ByteArrayOutputStream out = new ByteArrayOutputStream();
byte[] buffer = new byte[1024];
int n;
for (n = in.read(buffer); 0 < n; n = in.read(buffer))
{
    out.write(buffer, 0, n);
}
out.flush();
byte[] blob = out.toByteArray();