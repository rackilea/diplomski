InputStream in = socket.getInputStream();

// ...

ByteArrayOutputStream contentBuilder = new ByteArrayOutputStream();
byte[] buffer = new byte[32768]; // the size of this doesn't matter too much
int num_read;
while(true) {
    num_read = in.read(buffer);
    if(num_read < 0)
        break;
    contentBuilder.write(buffer, 0, num_read);
}
in.close();
writer.close();
return contentBuilder.toByteArray();