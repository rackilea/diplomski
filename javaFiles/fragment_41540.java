while (file1cellIterator.hasNext()&& file2cellIterator.hasNext()) {
                Cell file1cell = (Cell) file1cellIterator.next();
                Cell file2cell = (Cell) file2cellIterator.next();

                org.apache.poi.ss.usermodel.Cell cell = row.createCell(cellnum++);

                switch (file1cell.getCellType()) {
                case Cell.CELL_TYPE_BOOLEAN:
                    if ((file1cell.getBooleanCellValue())==(file2cell.getBooleanCellValue())){
                        ((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(file1cell.getBooleanCellValue());
                            }
                    else if((file1cell.getBooleanCellValue())!=(file2cell.getBooleanCellValue())){
                        ((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(file1cell.getBooleanCellValue());
                    }
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    if ((file1cell.getNumericCellValue())==(file2cell.getNumericCellValue())){
                        ((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(file1cell.getNumericCellValue());
                                                        }
                    else if((file1cell.getNumericCellValue())!=(file2cell.getNumericCellValue())){
                        ((org.apache.poi.ss.usermodel.Cell) cell).setCellValue((file1cell.getNumericCellValue())-(file2cell.getNumericCellValue()));
                                                }
                    break;
                case Cell.CELL_TYPE_STRING:
                    if ((file1cell.getStringCellValue())==(file2cell.getStringCellValue())){
                        ((org.apache.poi.ss.usermodel.Cell) cell).setCellValue(file1cell.getStringCellValue());
                            }
                    else if((file1cell.getStringCellValue())!=(file2cell.getStringCellValue())){
                        ((org.apache.poi.ss.usermodel.Cell) cell).setCellValue((file1cell.getStringCellValue())+(file2cell.getStringCellValue()));
                    }
                    break;
                default:
                    ((org.apache.poi.ss.usermodel.Cell) cell)
                            .setCellValue(file1cell.getStringCellValue());
                    break;
                }
            }
        }