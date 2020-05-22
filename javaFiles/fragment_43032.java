ByteArrayOutputStream stream = new ByteArrayOutputStream();
Deflater compresser = new Deflater(Deflater.BEST_COMPRESSION, true);
DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(stream, compresser);
deflaterOutputStream.write(input);
deflaterOutputStream.close();
byte[] output = stream.toByteArray();