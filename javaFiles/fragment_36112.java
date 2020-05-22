public List<Row> rows = new ArrayList<>(a.size());
for (int i=0; i < a.size(); i++) {
    rows.add(sheet.createRow(i));
}
List<List<String>> alphabet = new ArrayList<>();
alphabet.add(a);
alphabet.add(b);
alphabet.add(c);
for(int i=0; i < alphabet.size(); i++) {
    for (int j=0; j < alphabet.get(i).size(); j++) {
        String value = alphabet.get(i).get(j);
        Cell cell = rows.get(j).createCell(13 + i*2); //<- 13, 15, 17...
        cell.setCellValue(value);
    }
}