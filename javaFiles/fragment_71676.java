public static void main(String[] args) throws IOException {
    List<String> lines = new ArrayList<String>();
    BufferedReader reader = null;
    try {
        reader = new BufferedReader(new FileReader("file.txt"));
        String line = null;
        while ((line = reader.readLine()) != null) {
            lines.add(line);
        }
    } finally {
        reader.close();
    }
    String[] array = lines.toArray();
}