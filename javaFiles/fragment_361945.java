public String getDescription() {
    StringBuilder sb = new StringBuilder();
    String glue = "";
    if (line.contains("A")) {
        sb.append("Apple");
        glue = " & ";
    }
    if (line.contains("B")) {
        sb.append(glue);
        sb.append("Banana");
        glue = " & ";
    }
    if (line.contains("C")) {
        sb.append(glue);
        sb.append("Carrot");
    }
    return sb.toString();
}