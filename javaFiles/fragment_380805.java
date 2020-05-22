public AccountProjectDTO spreadsheets() {
    SpreadsheetService service = new SpreadsheetService("Sheet1");
    AccountProjectDTO accountProjectDTO = new AccountProjectDTO(); 
    [...]

        for (ListEntry le: lf.getEntries()) {
            [...]   
            return accountProjectDTO;
        }