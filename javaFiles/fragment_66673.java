connection.connect();
    int sizeBefore =  connection.getContentLength();
    BufferedInputStream bufferedInputStream = new BufferedInputStream(connection.getInputStream());
    File destFile = new File (destFileName);
    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(
            new FileOutputStream(destFile));
    while ((i = bufferedInputStream.read()) != -1) {
        bufferedOutputStream.write(i);
    }
    bufferedOutputStream.flush();
    bufferedInputStream.close();
    long sizeAfter = destFile.length();
    if (sizeAfter==sizeBefore) {
        log.info("Downloaded correct");                
    }