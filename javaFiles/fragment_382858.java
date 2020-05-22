public static String readFileAsString(File file) {
    try {
        DataInputStream in = new DataInputStream(FileInputStream(file));
        byte[] bytes = new byte[(int) file.length()];
        in.readFully(bytes);
        in.close();
        return new String(bytes, 0); // ASCII text only.

    } catch (FileNotFoundException e) {
        return null;
    } catch (IOException e) {
        System.out.println("Error:\n" + e.getMessage());
        return null;
    }
}

public static void main(String... args) throws IOException {
    File tmp = File.createTempFile("deleteme", "txt");
    tmp.deleteOnExit();

    byte[] bytes = new byte[4 * 1024 * 1024];
    Arrays.fill(bytes, (byte) 'a');
    FileOutputStream fos = new FileOutputStream(tmp);
    fos.write(bytes);
    fos.close();

    long start = System.nanoTime();
    String s = readFileAsString(tmp);
    long time = System.nanoTime() - start;
    System.out.printf("Took %.3f seconds to read a file with %,d bytes%n",
            time / 1e9, s.length());
}