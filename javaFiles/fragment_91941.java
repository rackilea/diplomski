try (DataInputStream stream = new DataInputStream(new FileInputStream(f))) {
    byte[] bytes = new byte[NUMBER_OF_BYTES];
    stream.read(bytes);
    String content = new String(bytes);
    System.out.println(content);
} catch (IOException e) {
    e.printStackTrace();
}