@Test
public void openFile() throws FileNotFoundException, IOException {
    File file = new File("/home/log.cfg");
    System.out.println(file.getAbsolutePath());
    FileInputStream fileInputStream = new FileInputStream("/home/log.cfg");
    int c;
    while(-1 != (c = fileInputStream.read())) {
        System.out.print((char) c);
    }
    fileInputStream.close();
}