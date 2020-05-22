FileOutputStream out = new FileOutputStream("abc.zip");
    ZipOutputStream zout = new ZipOutputStream(out);

    for(int i = 0; i < 5 ; i++) {
        byte[] documentBytes =  "12345".getBytes();
        ZipEntry zip = new ZipEntry(i+".txt");
        zout.putNextEntry(zip);
        zout.write(documentBytes);
        zout.closeEntry();
    }

    zout.close();