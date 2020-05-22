try (BufferedReader br1 = new BufferedReader(new FileReader(filename))) {
    StringBuilder sb = new StringBuilder();
    String line = br1.readLine();
    while (line != null) {
        sb.append(line);
        line = br1.readLine();
    }
    result = sb.toString();
} catch (IOException | RuntimeException e) {
    // TODO proper exception handling
}