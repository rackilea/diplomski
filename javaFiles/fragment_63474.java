public static void main(String args[]) throws Exception{

    String sPath = "C://Users//testusr//workspace//src//datasource//datasource.xlsx";
    ExcelUtils.setExcelFile(sPath, "sheet");

    for(int i=1; i<=7; i++){
        sActionKeyword = ExcelUtils.getCellData(i, 3);
        actionKeywords = new ActionKeywords();
        method = actionKeywords.getClass().getMethods();
        execute_Actions();
    }
}