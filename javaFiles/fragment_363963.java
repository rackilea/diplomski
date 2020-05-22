for (int i = 1; i < df.getRowCount(); i++) {
  //Assign your variables based on  the column headers
  x = df.getDataFromColumn("Column 1", i);
  y = df.getDataFromColumn("Column 2", i);
  z = df.getDataFromColumn("Column 3", i);
  //now you can use those variables for each row of data

}