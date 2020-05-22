String token = "YOUR_TOKEN";
Smartsheet smartsheet = new SmartsheetBuilder().setAccessToken(token).build();

// Define sheet to copy
Sheet sheet = new Sheet();
sheet.setName("New Sheet");

// Create columns for the new sheet
List<Column> columns = new ArrayList<Column>();
Column column = new Column();
column.setTitle("Column #1");
column.setPrimary(true);
column.setType(ColumnType.TEXT_NUMBER);
columns.add(column);

Column column2 = new Column();
column2.setTitle("Column #2");
column2.setType(ColumnType.TEXT_NUMBER);
columns.add(column2);
sheet.setColumns(columns);

// Define folder to put sheet in
long folderId = 907281073235844L;

// Create the new sheet and put it in the specified folder
Sheet newSheet = smartsheet.sheets().createSheetInFolder(folderId, sheet);
System.out.println(newSheet.getId());