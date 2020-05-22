public static String getSentence(Document doc, String word) {
    final String lcword = word.toLowerCase();
    Elements tableRows = doc.select("table#PassListView1 tr"); //selecting all rows of this table
    tableRows.remove(0); // removing first table row because it contains only headers
    Element selectedRow = null;
    for (Element row : tableRows) { // iterating through all the rows ...
        if (row.text().toLowerCase().contains(lcword)) { // ... to find the one you are looking for
            selectedRow = row;
        }
    }
    if (selectedRow == null) { //if no matching row found
        return getString(R.string.pizur_none);
    } else {
        //found matching row, so we're getting all the cells <td>
        Elements tds = selectedRow.select("td");
        for (Element td : tds) { // just displaying contents of every cell
            Log.d("TAG", td.text());
        }
        return tds.get(2).text(); // change number here to get what you want
    }
}