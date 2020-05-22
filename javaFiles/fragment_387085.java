public static void main(String[] args) {

        MyClass z = new MyClass();
        try {
            z.writerof("file.txt", 6);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public  void writerof(final String filePath, final int n) throws IOException {
        System.out.println("my method here");
    }