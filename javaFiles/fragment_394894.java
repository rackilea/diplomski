Workbook workbook = WorkbookFactory.create(new FileInputStream("C:\\file.xlsx"));

Sheet sheet = workbook.getSheetAt(0);
totalRows = sheet.getPhysicalNumberOfRows();

Map<String, Integer> map = new HashMap<String,Integer>(); //Create map
HSSFRow row = sheet.getRow(0); //Get first row
//following is boilerplate from the java doc
short minColIx = row.getFirstCellNum(); //get the first column index for a row
short maxColIx = row.getLastCellNum(); //get the last column index for a row
for(short colIx=minColIx; colIx<maxColIx; colIx++) { //loop from first to last index
HSSFCell cell = row.getCell(colIx); //get the cell
map.put(cell.getStringCellValue(),cell.getColumnIndex()) //add the cell contents (name of column) and cell index to the map
}

List<ReportRow> listOfDataFromReport = new ArrayList<ReportRow>();
for(int x = 1; x<=totalRows; x++){
 ReportRow rr = new ReportRow(); //Data structure to hold the data from the xls file.
 HSSFRow dataRow = sheet.getRow(x); //get row 1 to row n (rows containing data)

 int idxForColumn1 = map.get("Column1"); //get the column index for the column with header name = "Column1"
 int idxForColumn2 = map.get("Column2"); //get the column index for the column with header name = "Column2"
 int idxForColumn3 = map.get("Column3"); //get the column index for the column with header name = "Column3"

 HSSFCell cell1 = dataRow.getCell(idxForColumn1) //Get the cells for each of the indexes
 HSSFCell cell2 = dataRow.getCell(idxForColumn2) 
 HSSFCell cell3 = dataRow.getCell(idxForColumn3)  

 //NOTE THAT YOU HAVE TO KNOW THE DATA TYPES OF THE DATA YOU'RE EXTRACTING.
 //FOR EXAMPLE I DON'T THINK YOU CAN USE cell.getStringCellValue IF YOU'RE TRYING TO GET A NUMBER
 rr.setColumn1(cell1.getStringCellValue()); //Get the values out of those cells and put them into the report row object
 rr.setColumn2(cell2.getStringCellValue());
 rr.setColumn3(cell3.getStringCellValue());

 listOfDataFromReport.add(rr);

}

//Now you have a list of report rows
for(int j = 0; j< listOfDataFromReport.size();j++){
   System.out.println("Column 1 Value: " +   listOfDataFromReport.get(j).getColumn1())
//etc...    
}

//This class holds the values from the xls file.  You may not need it
// I have no idea what you're doing with the data.  If you simply wanted to 
//print the data to console you wouldn't need it.
public static class ReportRow{
private String column1;
private String column2;
private String column3;

public String getColumn1(){
    return this.column1;
}
public void setColumn1(String column1){
    this.column1 = column1;
}   

public String getColumn2(){
    return this.column2;
}
public void setColumn2(String column2){
    this.column2 = column2;
}       
public String getColumn3(){
    return this.column3;
}
public void setColumn3(String column3){
    this.column3 = column3;
}   
}