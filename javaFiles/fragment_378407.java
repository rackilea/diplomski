public static void load(String path) throws NumberFormatException,
        IOException {
    BufferedReader in = new BufferedReader(new FileReader(path));
    String line;
    while (null != (line = in.readLine())) {
        String field = line;
        Float avg = new Float(in.readLine());
        BM25Parameters.setAverageLength(field, avg);
    }
    in.close();
}