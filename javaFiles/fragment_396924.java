public static void main(String [] args) throws Exception{
    File f = new File ("/users/Me/Documents/Test.xls");
    Workbook wb = Workbook.getWorkbook(f);
    Sheet s = wb.getSheet(0);
    int row = s.getRows();
    int col = s.getColumns();
    for(int i = 0; i<row;i++){
            Cell c = s.getCell(4,i);
            System.out.print(c.getContents()+"\t");
        }
    System.out.println("");
}