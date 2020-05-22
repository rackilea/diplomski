DisplayFile setText(File file) {
    String entireFileText = null;
    try {
        entireFileText = new Scanner(file)
           .useDelimiter("\\A").next();
    } catch (FileNotFoundException e) {
         //Error handling
         e.printStackTrace();
    }
    jTextField1.setText(entireFileText);
    return this;
}