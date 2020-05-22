byte[] bytes = new byte[] {0,0,4,0,0,0,0,0};
    FileOutputStream fWriter;
    try {
        fWriter = new FileOutputStream(new File("D:\\testJava.txt"));
        fWriter.write(bytes);
    } catch (IOException e) {
        e.printStackTrace();
    }