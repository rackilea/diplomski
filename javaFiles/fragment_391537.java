public static void main(String[] args) throws IOException {
        File file = new File("C:\\createtable.sql");
        File copy = new File("C:\\copy.sql");

        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(copy);

        byte[] buffer = new byte[1024];

        int length;
        // copy the file content in bytes
        while ((length = fis.read(buffer)) > 0) {

            fos.write(buffer, 0, length);

        }

        fis.close();
        fos.close();

        System.out.println("File is copied successful!");
    }