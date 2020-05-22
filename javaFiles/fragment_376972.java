ByteArrayOutputStream buffer = new ByteArrayOutputStream();

CipherOutputStream cos = new CipherOutputStream(buffer, key);
... encode data ...

byte[] data = buffer.toByteArray();
zOut.write( data, 0, data.length );