StringBuilder col = new StringBuilder();
StringBuilder val = new StringBuilder();
String separator = "";
for (String c : columns) {
    if (pdf.hasKey(c)) {
        col.append(separator).append(c);
        val.append(separator).append("?");
        separator = ",";
    }
}