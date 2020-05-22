public SomeClass(String theName) {
    try {
        this.raf = new RandomAccessFile(theName, "r");
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    }
}