public class word {

    public enum TextOrientation {
          LTR,
          RTL
       }

    public static void main (String [] args) {

    XWPFDocument docx = new XWPFDocument();

    try {

    XWPFParagraph tmpParagraph = docx.createParagraph();   
    XWPFRun tmpRun = tmpParagraph.createRun();   
    tmpRun.setText("شهادة بالملك");
    tmpRun.setFontSize(18);  
    tmpRun.setFontFamily("Calibri (Corps)");
    tmpRun.setBold(true);
    tmpRun.setColor("003894");
    tmpParagraph.setAlignment(ParagraphAlignment.CENTER);
    tmpRun.setUnderline(UnderlinePatterns.SINGLE);
    tmpParagraph.setSpacingAfter(300);
    setOrientation(tmpParagraph, TextOrientation.RTL);

    FileOutputStream fos = new FileOutputStream("Word2.docx");
    docx.write(fos);
    fos.close();
    }
    catch (Exception e ) {
        e.printStackTrace();
    }
    }

    private static void setOrientation(XWPFParagraph par, TextOrientation orientation) {
          if ( par.getCTP().getPPr()==null ) {
              par.getCTP().addNewPPr();
          }
          if ( par.getCTP().getPPr().getBidi()==null ) {
             par.getCTP().getPPr().addNewBidi();
          }
          par.getCTP().getPPr().getBidi().setVal(orientation==TextOrientation.RTL?STOnOff.ON:STOnOff.OFF);
       }
}