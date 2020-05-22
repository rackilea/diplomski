public List<Row> rows = new ArrayList<Row>(a.size());

for (int i=0; i < a.size(); i++) {
    rows.add(sheet.createRow(i));
}

for (int i=0; i < a.size(); i++) {
     String value = a.get(i);
     Cell cell = rows.get(i).createCell(13);
     cell.setCellValue(value);
}

for (int i=0; i < b.size(); i++) {
     String value = b.get(i);
     Cell cell = rows.get(i).createCell(15);
     cell.setCellValue(value);
}

for (int i=0; i < c.size(); i++) {
     String value = a.get(i);
     Cell cell = rows.get(i).createCell(17);
     cell.setCellValue(value);
}