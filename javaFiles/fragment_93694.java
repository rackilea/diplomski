public void run() {
    BufferedOutputStream bufferedOutputStream = null;
    FileInputStream fileInputStream;

    File dest_file = new File(_location);
    dest_file.mkdirs(); // creates if destination directory not existed    

    try {
        fileInputStream = new FileInputStream(_zipFile);
        ZipInputStream zipInputStream = new ZipInputStream(new BufferedInputStream(fileInputStream));
        ZipEntry zipEntry;

        while ((zipEntry = zipInputStream.getNextEntry()) != null) {
            String zipEntryName = zipEntry.getName();
            File file = new File(_location + zipEntryName);

            if (file.exists()) {

            } else if (zipEntry.isDirectory()) {
                file.mkdirs();
            } else {
                byte buffer[] = new byte[1024];
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream, 1024);
                int count;

                while ((count = zipInputStream.read(buffer, 0, 1024)) != -1) {
                    bufferedOutputStream.write(buffer, 0, count);
                }
                bufferedOutputStream.flush();
                bufferedOutputStream.close();
            }
        }
        zipInputStream.close();
    } catch (Exception e) {
        Log.e("Decompress", "unzip", e);
    }
}