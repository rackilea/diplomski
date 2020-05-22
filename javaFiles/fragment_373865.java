public static void main(String[] args) throws IOException {
            // relative path from this class
    InputStream is = Test.class.getResourceAsStream("file.txt");
    byte[] content = new byte[4096];
    int length = is.read(content);
    System.out.println(new String(content, 0, length));

            // relative path from the root of the classpath
    is = Test.class.getClassLoader().getResourceAsStream("name/gpi/file.txt");
    content = new byte[4096];
    length = is.read(content);
    System.out.println(new String(content, 0, length));
}