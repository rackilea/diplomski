InputStream is = new FileInputStream(new File("/path/to/workbook.xlsx"));
StreamingReader reader = StreamingReader.builder()
        .rowCacheSize(100)    // number of rows to keep in memory (defaults to 10)
        .bufferSize(4096)     // buffer size to use when reading InputStream to file (defaults to 1024)
        .sheetIndex(0)        // index of sheet to use (defaults to 0)
        .sheetName("sheet1")  // name of sheet to use (overrides sheetIndex)
        .read(is);            // InputStream or File for XLSX file (required)