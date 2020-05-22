int rownum = 0;      
// loop start     
Row rowT = sheetTestcasenBurndown.getRow(rownum);    
for (int cellnumStart = 1; cellnumStart <= cellnumEnd; cellnumStart++) {     
    Cell cell = rowT.getCell(cellnumStart);       
    cell.setCellType(CellType.BLANK);    
}    
// loop end     
rownum++;