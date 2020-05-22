public class ExcelParser {

    private HSSFWorkbook wb;

    public ExcelParser(File xlsFile) throws Exception{

        wb = new HSSFWorkbook(new FileInputStream(xlsFile));
    }

    public String getValue(String sheetName, int rowNum, int celNum) throws Exception{
        try{
            HSSFSheet sheet = null;
            for(int i=0; i<wb.getNumberOfSheets();i++){
                if(wb.getSheetName(i).trim().toLowerCase().equals(sheetName.trim().toLowerCase())){
                    sheet = wb.getSheetAt(i);
                    break;
                }
            }
            if(sheet == null){
                throw new Exception("Sheet name '"+sheetName+"' not found.");
            }

            HSSFRow row     = sheet.getRow(rowNum);        
            if(row == null){return "";}
            HSSFCell cell   = row.getCell(celNum);
            if(cell== null){return "";}

            if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                return String.valueOf(cell.getNumericCellValue()).trim();
            } else if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING){
                return cell.getStringCellValue().trim();        
            }  else if (cell.getCellType() == HSSFCell.CELL_TYPE_ERROR){
                return "";//cell.getErrorCellValue();        
            }else if (cell.getCellType() == HSSFCell.CELL_TYPE_FORMULA){
                try{

                    return cell.getStringCellValue().trim();
                } catch (Exception e) {
                    return "";
                }
            } else{
                return cell.getStringCellValue().trim();
            }
        }
        catch (Exception e) {
            throw new Exception(e.getMessage()+" in row:"+rowNum+" col:"+celNum+" sheet:"+sheetName);
        }
    }
}