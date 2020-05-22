public static void main(String[] args) {
        try {
            writerof("file.txt", 6);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writerof(final String filePath, final int n) throws IOException {
        System.out.println("my method here");
    }