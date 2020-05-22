PDDocument pdfFile;
PDFTextStripper stripper;
List allPages;
PDPage page;
List<PDAnnotation> la = new ArrayList<PDAnnotation>();

stripper = new PDFTextStripper();
File file = new File("C:\\Users\\idobles\\Desktop\\CFM\\6 402402424.pdf");
pdfFile = PDDocument.load(file);    
allPages = pdfFile.getDocumentCatalog().getAllPages();
for(int i = 0; i < allPages.size(); i++){
     page = (PDPage) allPages.get(i);
     la = page.getAnnotations();
    if(la.size() < 1){
        continue;
    }
}