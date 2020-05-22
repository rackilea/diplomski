gzos = new GZIPOutputStream(baos);
    gzos.write(string.getBytes("UTF-8"));
    gzos.flush();
    gzos.close();

    return baos.toByteArray();