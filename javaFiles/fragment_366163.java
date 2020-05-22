try {
    FileReader fr = new FileReader(new File("..."));
    // Read file...
    fr.close();
} catch (IOException exp) {
    exp.printStackTrace();
}