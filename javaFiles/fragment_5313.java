static String readFile(String path) {
    FileInputStream stream = null;
    FileChannel channel = null;
    MappedByteBuffer buffer = null;

    try {
        stream = new FileInputStream(new File(path));
        channel = stream.getChannel();
        buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0,
                channel.size());
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try {
            stream.close();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    return Charset.defaultCharset().decode(buffer).toString();
}