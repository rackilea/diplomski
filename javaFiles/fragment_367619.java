URL url = new URL(route);
 File file = new File("file.pdf");
 FileUtils.copyURLToFile(url, file);

 PDDocument pdDoc = PDDocument.load(file);
 PDDocument document = null;

int pageNumberToRead=0;

try {   
    document = new PDDocument();   
    document.addPage((PDPage) pdDoc.getDocumentCatalog().getAllPages().get(pageNumberToRead));   
    document.save("basepath/first_page.pdf");  
    document.close();  
}catch(Exception e){}