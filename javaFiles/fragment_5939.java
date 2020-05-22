public synchronized InputStream getInputStream()
    throws IOException {

    int iconHeight;
    int iconWidth;

    connect();

    if (is == null) {
        if (isDirectory) {
            FileNameMap map = java.net.URLConnection.getFileNameMap();

            StringBuffer buf = new StringBuffer();

            if (files == null) {
                throw new FileNotFoundException(filename);
            }

            Collections.sort(files, Collator.getInstance());

            for (int i = 0 ; i < files.size() ; i++) {
                String fileName = files.get(i);
                buf.append(fileName);
                buf.append("\n");
            }
            // Put it into a (default) locale-specific byte-stream.
            is = new ByteArrayInputStream(buf.toString().getBytes());
        } else {
            throw new FileNotFoundException(filename);
        }
    }
    return is;
}