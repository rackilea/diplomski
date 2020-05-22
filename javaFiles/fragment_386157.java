for (int i = 0; i < sheet.getRows(); i++) {
    boolean rowEmpty = true;
    String currentRow = "";
    for (int j = 0; j < sheet.getColumns(); j++) {
        Cell cell = sheet.getCell(j, i);
        String con=cell.getContents();
        if(con !=null && con.length()!=0){
            rowEmpty = false;
        }
        currentRow += con + "|";
    }
    if(!rowEmpty) {
        System.out.println(currentRow);
    }
}