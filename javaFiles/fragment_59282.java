buffer = new byte[1024];
// Read from the InputStream
int totalRead = 0;
while(totalRead < 5)
{
    bytes = mmInStream.read(buffer,totalRead,5-totalRead);
    if(bytes==-1)
        throw new IOException("EOS reached");
    totalRead += bytes;
}