Integer rowIndex = GridPane.getRowIndex(node);
Integer columnIndex = GridPane.getColumnIndex(node);

if (rowIndex != null && rowIndex.intValue() == i
  && columnIndex != null && columnIndex.intValue() == j) {

    // ...
}