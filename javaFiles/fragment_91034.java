PDDocument pdoc = ...;
for(int pageNumber = 1; pageNumber < pdoc.getPageCount(); i++){

    PDFTextStripper s = new PDFTextStripper();
    s.setStartPage(pageNumber);
    s.setEndPage(pageNumber);
    String pageText = reader.getText(pdoc);
    String contents = s.getText(pdoc);  
    if(contents.contains("SUBSCRIPTION DETAILS")){
    ...
    }
}