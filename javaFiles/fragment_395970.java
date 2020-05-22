ZipFile         original = new ZipFile(INPUT_FILENAME);
ZipOutputStream outputStream = new ZipOutputStream(new FileOutputStream(OUTPUT_FILE));
Enumeration     entries = original.entries();
byte[]          buffer = new byte[512];
while (entries.hasMoreElements()) {
    ZipEntry    entry = (ZipEntry)entries.nextElement();
    if  ("word/document.xml".equalsIgnoreCase(entry.getName())) {
        //perform special processing
    }
    else{
        // create a new empty ZipEntry
        ZipEntry newEntry = new ZipEntry(entry.getName()); 
//      outputStream.putNextEntry(entry);
        outputStream.putNextEntry(newEntry);
        InputStream in = original.getInputStream(entry);
        while (0 < in.available()){
            int read = in.read(buffer);
            if (read > 0) {
              outputStream.write(buffer,0,read);
            }
        }
        in.close();
    }
    outputStream.closeEntry();
}
outputStream.close();