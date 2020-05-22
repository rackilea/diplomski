Get get = SHEETS.Spreadsheets.get(spreadsheetId);
Spreadsheet file = sheets.execute();
Sheet sheetToUpdate=null;
for(Sheet sheet: file.getSheets()){
   int index = sheet.getProperties().getIndex();
   //if this is the sheet you want to update
   sheetToUpdate = sheet;
}
int gid = sheetToUpdate.getProperties.getSheetId();