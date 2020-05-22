interface DataGridResources extends DataGrid.Resources
 {
  @Source(value = { DataGrid.Style.DEFAULT_CSS,
  "myDataGridStyle.css" })  // I should put the correct css file path here. 
  DataGrid.Style dataGridStyle();
 }