Inflater decompresser = new Inflater();
decompresser.setInput(data);
ByteArrayOutputStream bos = new ByteArrayOutputStream(data.length);
byte[] buffer = new byte[8192];
while (!decompresser.finished()) {
    int size = decompresser.inflate(buffer);
    bos.write(buffer, 0, size);
}
byte[] unzippeddata = bos.toByteArray();
decompresser.end();