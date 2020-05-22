public static void main(String[] args) {
    try {
        InputStream file = new FileInputStream(new    File("C:\\temp\\528.pdf"));
        FileOutputStream copy = new FileOutputStream("C:\\temp\\concatenatedforms.pdf");
        int b;
        while ((b = file.read()) != -1) {
            copy.write(b);
        }
        file.close();
    } catch(Exception e) {
        System.out.println(e);
    }
}