InputStream input = connection.getInputStream();
byte[] buffer = new byte[4096];
int cnt = - 1;

OutputStream output = new FileOutputStream(file);
while ( (cnt = input.read(buffer)) != -1)
{
  output.write(buffer, 0, cnt);
}
output.close();