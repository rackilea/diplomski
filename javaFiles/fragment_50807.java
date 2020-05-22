Map<String, List<String>> map = new HashMap<String, List<String>>(); 
      Workbook workBook=Workbook.getWorkbook(new File (filePath));
      String [] sheetNames = workBook.getSheetNames();
      Sheet sheet=null;
      for (int sheetNumber =0; sheetNumber < sheetNames.length; sheetNumber++){
         List<String > fields = new ArrayList<String>();
         sheet=workBook.getSheet(sheetNames[sheetNumber]);
         for (int columns=0;columns < sheet.getColumns();columns++){
             fields.add(sheet.getCell(columns, 0).getContents());                 
         }
         map.put(sheetNames[sheetNumber],fields); 
      }
      return map;
}