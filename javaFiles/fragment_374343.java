StringBuild sb = new StringBuilder(); // with linebreaks
List<String> lines = new ArrayList<>(); // each line one entry
for (int temp = 0; temp < nList.getLength(); temp++) {
    Node nNode = nList.item(temp);
    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
        String s = ...;
        if (sb.length() > 0) // add linebreak
            sb.append(System.getProperty("line.separator"));
        sb.append(s);
        lines.add(s);
    }
}