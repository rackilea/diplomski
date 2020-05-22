try (BufferedReader reader = new BufferedReader(new InputStreamReader(new SmbFileInputStream(file)))) {
    String line = reader.readLine();
    while (line != null) {
        line = reader.readLine();
    }
}