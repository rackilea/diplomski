public String escapeInput(String[] input) {
    String[] characters = {"\"", "\\", "{", "}"};
    StringBuilder sb = new StringBuilder();
    sb.append("\"");
    for (String line : input) {
        for (String test : characters) {
            line = line.replace(test, "\\" + test);
        }
        sb.append(line);
        sb.append("\n");
    }
    sb.append("\"");
    return sb.toString();
}