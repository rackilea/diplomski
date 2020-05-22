//construct the src and dest file structure
    File srcFile = new File(src, file);
    File destFile = new File(dest, file);
    while (destFile.exists()) {
        destFile = new File(dest, file + '-' + Instant.now());
    }