import org.apache.poi.ss.usermodel.CellType;
...
            switch (cell.getCellTypeEnum()) { //up to apache poi version 3.17
            //switch (cell.getCellType()) { //using apache poi version 4.0.0 upwards

                case STRING:
                    System.out.println(cell.getRichStringCellValue().getString());
                    break;
                case NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell)) {
                        System.out.println(cell.getDateCellValue());
                    } else {
                        System.out.println(cell.getNumericCellValue());
                    }
                    break;
                case BOOLEAN:
                    System.out.println(cell.getBooleanCellValue());
                    break;
                case FORMULA:
                    System.out.println(cell.getCellFormula());
                    break;
                case BLANK:
                    System.out.println();
                    break;
                default:
                    System.out.println();
            }
...