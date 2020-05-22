for(int i = 0; i < sheet.getLastRowNum(); i++){
        if(sheet.getRow(i)==null){
            sheet.shiftRows(i + 1, sheet.getLastRowNum(), -1);
            i--;
        continue;
        }
        for(int j =0; j<sheet.getRow(i).getLastCellNum();j++){
            if(sheet.getRow(i).getCell(j).toString().trim().equals("")){
                isRowEmpty=true;
            }else {
                isRowEmpty=false;
                break;
            }
        }
        if(isRowEmpty==true){
            sheet.shiftRows(i + 1, sheet.getLastRowNum(), -1);
            i--;
        }
    }