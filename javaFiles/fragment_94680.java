FileReader fr = null;
try {
    fr = new FileReader(file);
    BufferedReader br = new BufferedReader(fr);
    String line = null;
} catch (FileNotFoundException e) {
    e.printStackTrace();
} finally {
    if (fr != null) {
        try {
            fr.close();
        } catch (IOException e) {
            // This is unrecoverable. Just report it and move on
            e.printStackTrace();
        }
    }
}