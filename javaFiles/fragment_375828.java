try{
PDDocument document = null; 
document = PDDocument.load(new File("test.pdf"));
document.getClass();
if( !document.isEncrypted() ){
    PDFTextStripperByArea stripper = new PDFTextStripperByArea();
    stripper.setSortByPosition( true );
    PDFTextStripper Tstripper = new PDFTextStripper();
    String st = Tstripper.getText(document);
    System.out.println("Text:"+st);
}
}catch(Exception e){
    e.printStackTrace();
}