long total = 0;
byte[] bytes = new byte[8*1024];
InputStream in = socket.getInputStream();
int len;
while((len = in.read(bytes)) != -1)
    total += len;