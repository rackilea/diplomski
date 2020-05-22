public static void writeString(String in, File file, String charset, boolean append)
        throws IOException {
    writeBytes(in.getBytes(charset), file, append);
}

public static String readString(File file, String charset) throws IOException {
    return new String(readBytes(file), charset);
}