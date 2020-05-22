List<String> elements = new ArrayList<String>();
StringTokenizer st = new StringTokenizer((String) object);

while(st.hasMoreTokens()) {
    String[] row = st.nextToken().split(",");
    if (row.length > 3) {
        elements.add(row[3]);
    }
}