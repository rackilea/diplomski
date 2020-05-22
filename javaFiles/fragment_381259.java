int maxDownload = 1024*1024*2;
    URL website = new URL("http://www.wswd.net/testdownloadfiles/200MB.zip");

    byte[] outBytes = new byte[maxDownload];
    InputStream stream = website.openStream();

    IOUtils.read(stream, outBytes, 0, maxDownload);

    if (stream.read() != -1) {
        System.out.println("File too big");
    } 

    IOUtils.write(outBytes, new FileOutputStream("200MB.zip"));