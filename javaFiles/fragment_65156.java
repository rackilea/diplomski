InputStream in = endServerSocket.getInputStream();
OutputStream out = clientSocket.getOutputStream();
byte[] buffer = new byte[1024];
int bytesRead;
while ((bytesRead = in.read(buffer)) != -1)
{
    out.write(buffer, 0, bytesRead);
}

in.close();
out.close();