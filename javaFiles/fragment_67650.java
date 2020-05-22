BufferedOuputStream bufferedoutputstream = new BufferedOutputStream(new FileOutputStream(new File("location to save downloaded file")));
byte[] buffer = new byte[1024];
int bytesRead = 0;

while((bytesRead = inputstream.read(buffer)))
{
    bufferedoutputstream.write(buffer, 0, bytesRead);
}
bufferedoutputstream.flush();
bufferedoutputstream.close();
inputstream.close();