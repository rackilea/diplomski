HSSFCell cPaidAmount = null;
            if (theSICDataRow.getCell((short) 11) != null) {
                cPaidAmount = theSICDataRow.getCell((short) 11);

                if (cPaidAmount.getCellType()== HSSFCell.CELL_TYPE_NUMERIC) {
                    BigDecimal bd = new BigDecimal(cPaidAmount.getNumericCellValue());
                    if (bd.intValue() == 0) {
                        sPaidAmount = "0";
                    } 
                    else {
                        sPaidAmount = String.valueOf(bd.setScale(2, BigDecimal.ROUND_HALF_EVEN));
                    }
                } 
                else if (cPaidAmount.getCellType()== HSSFCell.CELL_TYPE_STRING) {
                    sPaidAmount = "" + cPaidAmount.getStringCellValue();
                }
                else if (cPaidAmount.getCellType()== HSSFCell.CELL_TYPE_BLANK) {
                    sPaidAmount = "0";
                }

            } 
            else if (theSICDataRow.getCell((short) 11) == null) {
                sPaidAmount = "0";
            }