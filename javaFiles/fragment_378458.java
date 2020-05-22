try (BufferedReader reader = new BufferedReader(
    new InputStreamReader(connection.getInputStream(), String_UTF_8))
) {
    String lines;
    while ((lines = reader.readLine()) != null) {
        sb.append(lines);
    }
}