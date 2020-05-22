// These are the files to include in the ZIP file
    String[] source = new String[]{"source1", "source2"};

    // Create a buffer for reading the files
    byte[] buf = new byte[1024];

    try {
        // Create the ZIP file
        String target = "target.zip";
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(target));

        // Compress the files
        for (int i=0; i<source.length; i++) {
            FileInputStream in = new FileInputStream(source[i]);

            // Add ZIP entry to output stream.
            out.putNextEntry(new ZipEntry(source[i]));

            // Transfer bytes from the file to the ZIP file
            int len;
            while ((len = in.read(buf)) > 0) {
                out.write(buf, 0, len);
            }

            // Complete the entry
            out.closeEntry();
            in.close();
        }

        // Complete the ZIP file
        out.close();
    } catch (IOException e) {
    }