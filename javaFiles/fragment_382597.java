for (int i = 0; i <= ColumnOneSize; i++) {
                    out.println("For");
                    out.println(ColOneList.get(i).getText());

                    //create row
                    XSSFRow row= sheetOne.createRow(i);
                    //to Column 1 
                    row.createCell(0).setCellValue(String.valueOf( ColOneobjectList.get(i)));        
                    //to Column 2
                    row.createCell(1).setCellValue((RichTextString) ColTwoobjectList.get(i));
    }