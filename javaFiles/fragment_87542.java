// class field holding association from readers to extension
Map<String, Reader> readers = new HashMap<String, Reader>();

// configuration (bean initialization for example)
readers.put("xml", xmlReader);
readers.put("xls", excelReader);
readers.put("txt", txtReader);

// execution would be something like:
List<EmployeeVO> list = readers.get(fileExtension).readList();