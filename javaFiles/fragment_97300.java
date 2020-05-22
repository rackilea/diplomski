int count;
byte[] buffer = new byte[8192]; // or whatever you like
while ((count = in.read(buffer)) > 0)
{
  out.write(buffer, 0, count);
}
out.close();
in.close();