ZipEntry zipEntry = jarInputStream.getNextEntry();
while (zipEntry != null) {
    fos.putNextEntry(zipEntry);

    // Simple stream copy comes here
    int BUFFER_SIZE = 10240;
    byte buffer[] = new byte[BUFFER_SIZE];
    int l = jarInputStream.read(buffer);
    while(l >= 0) {
        fos.write(buffer, 0, l);
        l = jarInputStream.read(buffer);
    }

    zipEntry = jarInputStream.getNextEntry();
}