public class SO3 {
public static void main(String[] args){

XWPFDocument document = new XWPFDocument();
XWPFParagraph paragraphOne = document.createParagraph();
XWPFRun paragraphOneRunOne = paragraphOne.createRun();
paragraphOneRunOne.setBold(true);
paragraphOneRunOne.setItalic(true);
paragraphOneRunOne.setText("Hello world! This is paragraph one!");
paragraphOneRunOne.addBreak();

try {
    FileOutputStream outStream = new FileOutputStream("D:\\Users\\user2777005\\Desktop\\MyDov.docx");
    document.write(outStream);
    outStream.close();
} catch (IOException e) {
    e.printStackTrace();
}

try{
FileInputStream is = new FileInputStream(new File("D:\\Users\\user2777005\\Desktop\\MyDov.docx"));

XWPFDocument doc = new XWPFDocument(is);
List<XWPFParagraph> paras = doc.getParagraphs(); //This list will hold the paragraphs
XWPFWordExtractor ex = new XWPFWordExtractor(doc);  //To get the words
String words = ""; //This will hold all the text
    for(XWPFParagraph p : paras){  //For each paragraph we retrieved from the document
      words += p.getText();    //Add the text we retrieve to the words string  
    }

    System.out.println(words); //Check out string
    XWPFDocument newDoc = new XWPFDocument(); 
    XWPFParagraph para = newDoc.createParagraph();
    XWPFRun run = para.createRun();     
   //You have to reformat the run with bold/italic e.t.c if you want
    run.setText(words);
    newDoc.write(new FileOutputStream(new File("D:\\Users\\user2777005\\Desktop\\mydoc.docx")));}
   catch (IOException e)
{System.out.println(e);}
}}