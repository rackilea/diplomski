public static void main(String[] args) throws IOException {
    try (FileInputStream fis = new FileInputStream("./fos.txt");
         FileOutputStream fos = new FileOutputStream("./copy.txt")) {

        byte[] buffer = new byte[8 << 10]; // 8 KB
        for (int len; (len = fis.read(buffer)) != -1; )
            fos.write(buffer, 0, len);
    }
}