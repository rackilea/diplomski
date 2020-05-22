HSSFWorkbook workbook = null; // creating a new workbook
File file = new File(context.getExternalFilesDir(null), "Sample.xls"); //getting a file with this name if not exist will create a new excel file with this in below steps
FileOutputStream fileOut = new FileOutputStream(file); // output stream is used to write to a file

if (file.exists()) { // if file exists add a new workbook to it 
    try {
        workbook = (HSSFWorkbook)WorkbookFactory.create(file);
    } catch (InvalidFormatException e) {
        e.printStackTrace();
    }
    //add logic to convert the input to excel rows and write it into a wrokbook like this
    HSSFSheet sheet = workbook.createSheet("Sample sheet2");

}
else{ // create a new workbook
    workbook = new HSSFWorkbook();
    // for the first time if nothing is there this will execute 
    //add logic to convert the input to excel rows and write it into a wrokbook like this
    HSSFSheet sheet = workbook.createSheet("Sample sheet1");
}
workbook.write(fileOut); // closing the workbook after all operations
fileOut.close(); // closing the output stream