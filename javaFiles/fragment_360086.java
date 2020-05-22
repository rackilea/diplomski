static void write() throws IOException {
    BufferedWriter out = new BufferedWriter(new FileWriter("flip.out"));
    try {
        out.write(sMax);
        out.flush();
    } catch (Exception e) {
        // probably could ditch this and 
        // just the exception bubble up and 
        // handle it higher up.
        e.printStackTrace(); 
    } finally {
        out.close();
    }
}