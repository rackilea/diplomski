for(int i=1;i<=nPages;i++){
    textFromPage = PdfTextExtractor.getTextFromPage(reader, i);
    System.out.println("page"+i+" "+textFromPage);
    fw=new FileWriter("input.txt",true);
    bw=new BufferedWriter(fw);
    bw.write(textFromPage);
    System.out.println(textFromPage);
}