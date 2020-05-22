ZipInputStream zis = new ZipInputStream(new ByteArrayInputStream(allzipdata));
    ZipEntry ze = null;
    while ((ze = zis.getNextEntry()) != null) {
       // write your code to use zip entry e.g. below:
       String filename = ze.getName();
       System.out.println("File Name of Entry file="+fileName);
       byte[] data = IOUtils.toByteArray(zis);
       // now work with the image `data`
    }