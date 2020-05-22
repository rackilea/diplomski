JasperDesign design = JRXmlLoader.load("YourReport.jrxml");
moveDesign(design,x,y);
JasperReport report = JasperCompileManager.compileReport(design);

private void moveDesign(JasperDesign design, int x, int y) {
    int maxX = 100; //I define it so that elements is not out of report
    int maxY = 100;

    int pageWidth = design.getPageWidth();
    int intitalLeftMargin = design.getLeftMargin();
    int intitalRightMargin = design.getRightMargin();
    int intitalTopMargin= design.getTopMargin();

    //Check that not less then 0 and not more then my max       
    int newLeftMargin = Math.min(Math.max(intitalLeftMargin+x,0),maxX);
    int newTopMargin = Math.min(Math.max(intitalTopMargin+y,0),maxY);

    //set our new margins
    int newColumWidth = pageWidth - newLeftMargin - intitalRightMargin;
    design.setLeftMargin(newLeftMargin);
    design.setTopMargin(newTopMargin);
    design.setColumnWidth(newColumWidth);
}