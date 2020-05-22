int count;
byte[] buffer = new byte[8192]; // more if you like but no need for it to be the entire file size
while ((count = in.read(buffer)) > 0)
{
  out.write(buffer, 0, count);
}