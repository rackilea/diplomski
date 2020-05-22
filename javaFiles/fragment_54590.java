File dir = new File(destDir);

if(!dir.exists()) dir.mkdirs();
FileInputStream fis;

byte[] buffer = new byte[1024];
try {
    fis = new FileInputStream(zipFilePath);
    ZipInputStream zis = new ZipInputStream(fis);
    ZipEntry ze = zis.getNextEntry();

    while(ze != null){
        String fileName = ze.getName();
        File newFile = new File(destDir + File.separator + fileName);

        new File(newFile.getParent()).mkdirs();
        FileOutputStream fos = new FileOutputStream(newFile);
        int len;

        while ((len = zis.read(buffer)) > 0) {
            fos.write(buffer, 0, len);
        }

        fos.close();
        zis.closeEntry();
        ze = zis.getNextEntry();
    }
    zis.closeEntry();
    zis.close();
    fis.close();

} catch (IOException e) {
    e.printStackTrace();
}