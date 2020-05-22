XWPFTableRow rowOne = table.getRow(0);
                XWPFParagraph paragraph = rowOne.getCell(0).addParagraph();
                setRun(paragraph.createRun() , "Calibre LIght" , 10, "2b5079" , "Some string" , false, false);

private static void setRun (XWPFRun run , String fontFamily , int fontSize , String colorRGB , String text , boolean bold , boolean addBreak) {
        run.setFontFamily(fontFamily);
        run.setFontSize(fontSize);
        run.setColor(colorRGB);
        run.setText(text);
        run.setBold(bold);
        if (addBreak) run.addBreak();
    }