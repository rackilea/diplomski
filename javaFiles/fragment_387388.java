public void ZIPandGZIP(String fileName, OutputStream os, String header) throws FileNotFoundException {
    byte[] buffer = new byte[1024];
    FileInputStream fis = null;
    FileOutputStream fos = null;
    ZipOutputStream zos = null;
    File tempZipFile = File.createTempFile(fileName, ".zip")
    try {
        fos = new FileOutputStream(tempZipFile);
        zos = new ZipOutputStream(fos);
        ZipEntry ze = new ZipEntry(fileName);
        zos.putNextEntry(ze);
        fis = new FileInputStream(fileName);

        int len;
        while ((len = fis.read(buffer)) > 0) {
            zos.write(buffer, 0, len);
        }
        zos.closeEntry();
    } catch (IOException ex) {
        ex.printStackTrace();
    } finally {
        if (fis != null) {
            fis.close();
        }
        if (zos != null) {
            zos.close();
        }
        if (fos != null) {
            fos.close();
        }
    }

    addGzipFileToStream(tempZipFile, os, header);
}

private void addGzipFileToStream(File zipFile, OutputStream os, String header) throws FileNotFoundException {

    byte[] buffer = new byte[1024];
    DataOutputStream dos = null;
    GZIPOutputStream gzos = null;
    FileInputStream inputStream = null;
    try {
        dos = new DataOutputStream(os);
        dos.writeBytes(header);

        gzos = new GZIPOutputStream(os);
        inputStream = new FileInputStream(zipFile);

        int len;
        while ((len = inputStream.read(buffer)) > 0) {
            gzos.write(buffer, 0, len);
        }
        gzos.finish();
    } catch (IOException ex) {
        ex.printStackTrace();
    } finally {
        if (inputStream != null) {
            inputStream.close();
        }
        if (gzos != null) {
            gzos.close();
        }
        if (dos != null) {
            dos.close();
        }
        zipFile.delete();
    }
}