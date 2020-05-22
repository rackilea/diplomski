String token = "YOUR_TOKEN";
Smartsheet smartsheet = new SmartsheetBuilder().setAccessToken(token).build();

// Define sheet to copy
Sheet sheet = new Sheet();
sheet.setFromId(7298027523204996L);
// Define folder to put sheet in
long folderId = 907281173235844L;

// copy the sheet to the specified folder
Sheet newSheet = smartsheet.sheets().createSheetInFolder(folderId, sheet);
System.out.println(newSheet.getId());