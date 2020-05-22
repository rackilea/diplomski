public TestRead() {
    //...
    textArea.setLineWrap(true);
    textArea.setWrapStyleWord(true);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    try {
        openFile();
    } catch (IOException exp) {
        exp.printStackTrace();
    }
}//ends constructor