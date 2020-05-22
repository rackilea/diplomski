ServletInputStream dataStream = req.getInputStream();
ByteArrayOutputStream baos = new ByteArrayOutputStream();

int r;
byte[] buffer = new byte[1024*1024];

while ((r = dataStream.read(data, 0, buffer.length)) != -1) {
   baos.write(buffer, 0, r);
} 

baos.flush();

byte[] data = baos.toByteArray();