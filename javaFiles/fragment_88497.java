@GetMapping("/down")
public ResponseEntity<byte[]> down() throws IOException {
    ByteArrayOutputStream outByteStream = new ByteArrayOutputStream();
        Workbook wb = new HSSFWorkbook();
        for(int sNo=1;sNo<=5;sNo++) {
            Sheet sheet = wb.createSheet("s"+sNo);
            for(int i=1;i<6;i++) {
                Row row = sheet.createRow(i);
                for(int j=1;j<=5;j++) {
                    Cell cell = row.createCell(j);
                    cell.setCellValue("test "+j);
                }

            }
        }
        wb.write(outByteStream);
        wb.close();

       MultiValueMap<String, String> headers = new HttpHeaders();
       List<String> list = new ArrayList<>();
       list.add("application/vnd.ms-excel");
       headers.put(HttpHeaders.CONTENT_TYPE, list);
    return new ResponseEntity<byte[]>(outByteStream.toByteArray(),headers, HttpStatus.OK);
}