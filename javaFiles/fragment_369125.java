public void parseTable() {
    Document doc = Jsoup.parse(html);

    // declare a holder to contain the 'mapped rows', this is a map based on the assumption that every row represents a discreet key:value pair
    Map<String, String> asMap = new HashMap<>();
    Element table = getTable(doc);

    // now walk though the rows creating a map for each one
    Elements rows = table.select("tr");
    for (int i = 0; i < rows.size(); i++) {
        Element row = rows.get(i);
        Elements cols = row.select("td");

        // expecting this table to consist of key:value pairs where the first cell is the key and the second cell is the value
        if (cols.size() == 2) {
            asMap.put(cols.get(0).text(), cols.get(1).text());
        } else {
            throw new RuntimeException(String.format("Cannot parse the table row: %s to a key:value pair because it contains %s cells!", row.text(), cols.size()));
        }
    }
    System.out.println(asMap);
}

private Element getTable(Document doc) {
    Elements tables = doc.select("table");
    for (int i = 0; i < tables.size(); i++) {
        // this xpath //td[text() = 'TestSet URL']/ancestor::table[1] will find the first table which contains the
        // text "TestSet URL" anywhere in its body
        // this crude evaluation is the JSoup equivalent of that xpath
        if (tables.get(i).text().contains("TestSet URL")) {
            return tables.get(i);
        }
    }
    throw new RuntimeException("Cannot find a table element which contains 'TestSet URL'!");
}