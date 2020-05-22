public static void main(String[] args) throws Exception {
    FileReader fr = new FileReader("D:/test.txt");
    BufferedReader br = new BufferedReader(fr);
    boolean isFileChanged = false;
    while (true) {
        String line = br.readLine();
        if (line == null) {
            if (isFileChanged){
                isFileChanged = false;
                sendEmail();
            }
            Thread.sleep(1 * 1000);
        }
        else {
            isFileChanged = true;
            byte[] y = line.getBytes();
            File g = new File("D:/abc.txt");
            try (OutputStream f = new FileOutputStream(g, true)) {
                f.write(y);
            }
        }

    }
}