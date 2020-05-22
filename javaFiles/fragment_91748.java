if (cell != null){
   cell.setCellStyle(whiteFG);
}
else if ( "".equals(cell.getStringCellValue()) ){       
    cell.setCellStyle(whiteFG);
}