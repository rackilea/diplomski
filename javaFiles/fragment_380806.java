public List<AccountProjectDTO> spreadsheets() {
    SpreadsheetService service = new SpreadsheetService("Sheet1");
    List<AccountProjectDTO> result = new ArrayList<>();
    [...]

        for (ListEntry le: lf.getEntries()) {
            AccountProjectDTO accountProjectDTO = new AccountProjectDTO(); 
            [...]   
            result.add(accountProjectDTO);
        }
    return result;
}