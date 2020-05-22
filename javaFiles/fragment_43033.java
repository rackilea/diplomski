ByteArrayOutputStream stream2 = new ByteArrayOutputStream();
    Inflater decompresser = new Inflater(true);
    InflaterOutputStream inflaterOutputStream = new InflaterOutputStream(stream2, decompresser);
    inflaterOutputStream.write(output);
    inflaterOutputStream.close();
    byte[] output2 = stream2.toByteArray();