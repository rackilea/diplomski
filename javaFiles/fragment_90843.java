ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(new File("your zip file name")));
    ZipEntry entry = new ZipEntry("zipped file name");
    entry.setSize(bytes.length);
    zos.putNextEntry(entry);
    zos.write(bytes);
    zos.closeEntry();
    zos.close();