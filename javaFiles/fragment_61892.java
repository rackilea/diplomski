public void seccionObservaciones(XWPFDocument doc, XWPFRun otrasObservaciones, XWPFParagraph observaciones){ //TABLE METHOD

    otrasObservaciones = observaciones.createRun();
    otrasObservaciones.setText(".");
    otrasObservaciones.addBreak();
     //create table
    XWPFTable table = doc.createTable();
    //create first row
    XWPFTableRow tableRowOne = table.getRow(0);
    tableRowOne.getCell(0).setText("Otras Operaciones/Observaciones");

for (XWPFParagraph p : tableRowOne.getCell(0).getParagraphs()) {
 p.getCTP().addNewPPr().addNewKeepLines().setVal(STOnOff.ON);
 p.getCTP().getPPr().addNewKeepNext().setVal(STOnOff.ON);
}

    //create second row
    XWPFTableRow tableRowTwo = table.createRow();
    tableRowTwo.getCell(0).getTableRow(); 
    tableRowTwo.getCell(0).setText("col fore, row fore");

for (XWPFParagraph p : tableRowTwo.getCell(0).getParagraphs()) {
 p.getCTP().addNewPPr().addNewKeepLines().setVal(STOnOff.ON);
 p.getCTP().getPPr().addNewKeepNext().setVal(STOnOff.ON);
}

 }