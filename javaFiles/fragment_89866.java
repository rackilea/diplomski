public class ExcelReader {

  public static void main(String[] args) {
    String jsonString = new ExcelReader().fileToJson("stack.xlsx");
    System.out.print(jsonString);
  }

  // Parses the file into a JSON string
  private String fileToJson(String filename) {
    List<XSSFSheet> sheets = getSheets(filename);
    Map<String, Map<String, List<Map<String, Map<String, Integer>>>>> workbookMap = parseSheets(sheets);
    return toJsonString(workbookMap);
  }

  // Make a list of XSSFSheets out of the file
  private List<XSSFSheet> getSheets(String fileName) {
    List<XSSFSheet> sheets = new ArrayList<>();
    try(InputStream XlsxFileToRead = new FileInputStream(fileName)) {
      //Getting the workbook instance for xlsx file
      XSSFWorkbook workbook = new XSSFWorkbook(XlsxFileToRead);

      //Getting all the sheets
      for (int i=0; i<workbook.getNumberOfSheets(); i++) {
        sheets.add(workbook.getSheetAt(i));
      }

    } catch (IOException e) {
      e.printStackTrace();
    }
    return sheets;
  }

  // Parse a list of sheets into the desired structure
  private Map<String, Map<String, List<Map<String, Map<String, Integer>>>>> parseSheets(List<XSSFSheet> xsshSheets) {
    Map<String, Map<String, List<Map<String, Map<String, Integer>>>>> workbookMap = new HashMap<>();
    for(XSSFSheet xssfSheet : xsshSheets) {
      String name = xssfSheet.getSheetName();
      Map<String, List<Map<String, Map<String, Integer>>>> sheetMap = parseSheet(xssfSheet);
      workbookMap.put(name, sheetMap);
    }
    return workbookMap;
  }


  // Parses a sheet into the desired structure
  private Map<String, List<Map<String, Map<String, Integer>>>> parseSheet(XSSFSheet xsshSheet) {
    List<Map<String, Map<String, Integer>>> months = extractTable(xsshSheet, "Month");
    List<Map<String, Map<String, Integer>>> weeks = extractTable(xsshSheet, "Week");
    List<Map<String, Map<String, Integer>>> days = extractTable(xsshSheet, "Daily");

    Map<String, List<Map<String, Map<String, Integer>>>> sheet = new HashMap<>();
    sheet.put("MONTH", months);
    sheet.put("WEEK", weeks);
    sheet.put("DAILY", days);
    return sheet;
  }

  // Extracts a table
  private List<Map<String, Map<String, Integer>>> extractTable(XSSFSheet sheet, String tableName) {
    Cell tablePosition = findTablePosition(sheet, tableName);
    if(tablePosition!=null)
      return extractTable(sheet, tablePosition);
    else return null;
  }

  // Finds the position of the cell with the given text
  private Cell findTablePosition(XSSFSheet sheet, String tableName) {
    for (Row row : sheet) {
      for (Cell cell : row) {
        if(cell.getCellTypeEnum() == CellType.STRING && tableName.equals(cell.getStringCellValue())) {
          return cell;
        }
      }
    }
    return null;
  }

  // Extract a table
  private List<Map<String, Map<String, Integer>>> extractTable(XSSFSheet sheet, Cell tablePosition) {
    List<Map<String, Map<String, Integer>>> table = new ArrayList<>();

    int headerRow = tablePosition.getRowIndex();
    int valuesHeaderColumn = tablePosition.getColumnIndex();

    // read all columns and rows until finding an empty one
    int row = headerRow + 1;
    int col = valuesHeaderColumn + 1;

    // read all columns starting at col
    while(true) {
      Map<String, Map<String, Integer>> tableColumn = new HashMap<>();
      Cell headerCell = sheet.getRow(headerRow).getCell(col);
      if(headerCell == null)
        break;
      String columnName = headerCell.getStringCellValue().toUpperCase();
      if("".equals(columnName))
        break;

      // read all rows starting at row
      Map<String, Integer> values = new HashMap<>();
      while(true) {
        Row valueHeaderRow = sheet.getRow(row);
        if(valueHeaderRow == null)
          break;
        Cell valueHeaderCell = valueHeaderRow.getCell(valuesHeaderColumn);
        String valueHeader = valueHeaderCell.getStringCellValue();
        if("".equals(valueHeader))
          break;
        Cell valueCell = sheet.getRow(row).getCell(col);
        Integer value = (int)valueCell.getNumericCellValue();
        values.put(valueHeader, value);
        row++;
      }

      tableColumn.put(columnName, values);
      // Add the columns map to the list
      table.add(tableColumn);
      col++;
      row = headerRow + 1;
    }
    return table;
  }

  // Create the JSON string using Jackson ObjectMapper
  private String toJsonString(Object o) {
    ObjectMapper objectMapper = new ObjectMapper();
    String jsonString = null;
    try {
      jsonString = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
    } catch(JsonProcessingException e) {
      e.printStackTrace();
    }
    return jsonString;
  }
}