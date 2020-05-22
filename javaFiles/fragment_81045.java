Sheets sheetsService = createSheetsService();
Sheets.Spreadsheets.Values.Get request =
    sheetsService.spreadsheets().values().get(spreadsheetId, range);
request.setValueRenderOption(valueRenderOption);

ValueRange response = request.execute();