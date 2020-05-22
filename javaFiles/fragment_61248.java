public static byte[] readBytes(File file) throws IOException {
    return readBytes(file, (int) file.length());
}

public static byte[] readBytes(File file, int length) throws IOException {
    byte[] content = new byte[length];
    FileInputStream fis = null;

    try {
        fis = new FileInputStream(file);

        while (length > 0)
            length -= fis.read(content);
    } finally {
        if (fis != null)
            fis.close();
    }

    return content;
}