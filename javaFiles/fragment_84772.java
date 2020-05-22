List<Row> toRemove = new ArrayList<Row>()
  while (rowIterator.hasNext()) {
            Row row = rowIterator.next(); // throws ConcurrentModificationException
            if (row_count == 0) {
                col_count = row.getLastCellNum();
                //Do something
            } else {
                if (row.getCell(1).equals("XYZ")) {
                  toRemove.add(row);
                }
            }
            row_count++;
        }
// loop the list and call sheet.removeRow() on every entry
    ...