Document doc = Jsoup.parse(html);
Elements tables = doc.select("table");
for (Element table : tables) {
    Elements trs = table.select("tr");
    String[][] trtd = new String[trs.size()][];
    for (int i = 0; i < trs.size(); i++) {
        Elements tds = trs.get(i).select("td");
        trtd[i] = new String[tds.size()];
        for (int j = 0; j < tds.size(); j++) {
            trtd[i][j] = tds.get(j).text(); 
        }
    }
    // trtd now contains the desired array for this table
}