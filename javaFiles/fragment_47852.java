try (FileOutputStream out = new FileOutputStream("/some/file")) {
    try (InputStream in = sftpChannel.get(fileName)) {
        // read from in, write to out
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }
    }
}