private static String getRangeNameA1Str(String spreadsheetId, String rangeNameStr)
    throws IOException
{
    // Get spreadsheet by its ID.
    Spreadsheet spreadsheet = sheetsService.spreadsheets().get(spreadsheetId).execute();

    // Get named range.
    NamedRange namedRange =
        spreadsheet.getNamedRanges().parallelStream()
            .filter(aRange -> aRange.getName().equals(rangeNameStr))
            .findFirst()
            .get();

    // Get named range's GridRange for its A1 notation components.
    GridRange gridRange = namedRange.getRange();

    // Get named range's sheet's name.
    Integer  sheetID = gridRange.getSheetId(); // *** This call was getting null but then started getting the correct sheet ID.
    String sheetName =
        spreadsheet.getSheets().parallelStream()
            .filter(aSheet -> aSheet.getProperties().getSheetId().equals(sheetID))
            .findFirst()
            .get()
            .getProperties()
            .getTitle();

    // Get named range's A1 notation from its GridRange's components.
    String rangeA1Str =
        sheetName + "!" +
        Character.toString((char)((int)gridRange.getStartColumnIndex()+65)) +
        (gridRange.getStartRowIndex()+1) +
        ":" +
        Character.toString((char)((int)gridRange.getEndColumnIndex()+65)) +
        gridRange.getEndRowIndex();


    return(rangeA1Str);
} // getNamedRangeA1String
public static Sheets getSheetsService()
    throws IOException
{
    Credential credential = authorize();
    return new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, credential)
    .setApplicationName(APPLICATION_NAME)
    .build();
} // getSheetsService