public static void main(String[] args) throws Exception {
    FileInputStream fis = new FileInputStream("src/file.txt");
    int i = 0;
    while (i < 50) { // read only 50 bytes
        byte b = (byte)fis.read();

        if (b == -1) { // end of file, wait
            Thread.sleep(500L);
            continue;
        }
        System.out.print((char) b);
        i++;
    }
    fis.close();
}