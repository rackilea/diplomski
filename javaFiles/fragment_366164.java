FileReader fr = nulll;
try {
    fr = new FileReader(new File("..."));
    // Read file...
} catch (IOException exp) {
    exp.printStackTrace();
} finally {
    try {
        // Avoid NullPointerException's
        if (fr != null) {
            fr.close();
        }
    } catch (Exception exp) {
    }
}