try {
    FileInputStream fis = (FileInputStream) inputStream;
    FileChannel channel = fis.getChannel();
    ByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());

    byte[] bytes = new byte[102];
    buffer.get(bytes);
    System.out.println(new String(bytes));
} catch (IOException e) {
    e.printStackTrace();
}