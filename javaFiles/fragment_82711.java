public static void main(String[] args) throws IOException {
        File A = new File("A");
        File B = new File("B");
        File C = new File("C");
        File D = new File("D");

        File E = new File("E");
        mergeFiles(E, A, B, C, D);
}

static void mergeFiles(File destination, File... files) throws IOException {
    byte[] buffer = new byte[512];
    int count;
    try (FileOutputStream fos = new FileOutputStream(destination)) {
        for (File file : files) {
            try (FileInputStream fis = new FileInputStream(file)) {
                while ((count = fis.read(buffer)) != -1) {
                    fos.write(buffer, 0, count);
                }
            }
        }
    }
}