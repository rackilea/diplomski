LinkedList < String[] > llist = new LinkedList < > ();

String[] data;

File temp = new File("file.txt");
BufferedWriter bw = new BufferedWriter(new FileWriter(temp));

XSSFWorkbook workBook = new XSSFWorkbook();
FileOutputStream outstream = new FileOutputStream("data.xls");
XSSFSheet spreadSheet = workBook.createSheet("Clean");

for (int i = 0; i < llist.size(); i++) {
 if (i == 0) {
  bw.newLine();
 } else {
  data = llist.get(i);

  String empid1 = data[0];
  String fname = data[1];
  String ccode1 = data[2];

  if (data[2].equals("IND")) {
   replace = data[2].replaceAll("IND", "IN");
   ccode1 = replace;
  } else if (data[2].equals("USA")) {
   replace = data[2].replaceAll("USA", "US");
   ccode1 = replace;
  } else {
   ccode1 = data[2];
  }

  //String newData=empid1+","+fname+","+ccode1;

  XSSFRow row = spreadSheet.createRow(i);

  XSSFCell cell = row.createCell(0);
  cell.setCellValue(empid1);

  cell = row.createCell(1);
  cell.setCellValue(fname);

  cell = row.createCell(2);
  cell.setCellValue(ccode1);
 }
}

workBook.write(outstream);
bw.close();