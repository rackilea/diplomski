Element table = document
  .select("table.easy-table-creator:nth-child(1) tbody").first();
Elements trAll = table.select("tr");
Elements trAllBody = table.select("tr:not(:first-child)");

// For the Table Hour
Element trFirst = trAll.first();
Elements tds = trFirst.select("td");
for(int i = 0; i < tds.size(); i++){
    Element td = tds.get(i);
    Log.d("TIME TABLE:", " " + td.text());

    String query = "td:nth-child(" + (i + 1) + ")";
    Elements subTds = trAllBody.select(query);
    for (int j = 0; j < subTds.size(); j++) {
        Element subTd = subTds.get(j);
        String tdText = subTd.text();
        if(!tdText.isEmpty()){                  
            Log.d("TD INSIDE:", " " + subTd.text());
        }
    }
}