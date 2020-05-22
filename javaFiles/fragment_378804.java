List<JRPrintPage> pages = jasperPrint.getPages();
for (JRPrintPage jrPrintPage : pages) {
    List<JRPrintElement> elements = jrPrintPage.getElements();
    for (JRPrintElement jjpe : elements) {
        jjpe.setX(newX);
        jjpe.setY(newX);    
    }   
}