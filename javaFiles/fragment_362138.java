byte[] buffer = new byte[8192];
ByteArrayOutputStream output = new ByteArrayOutputStream();
int bytesRead;
while ((bytesRead = inputStream.read(buffer)) != -1)
{
    output.write(buffer, 0, bytesRead);
}
// Now use the data in "output"