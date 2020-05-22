public class testPOI {

public static void main(String[] args) throws Exception{

    String filepath = "F:\\MASTER_DOC.docx";
    String outpath = "F:\\Test.docx";

    XWPFDocument doc = new XWPFDocument(new FileInputStream(filepath));
    for (XWPFParagraph p : doc.getParagraphs()){

        int numberOfRuns = p.getRuns().size();

        // Collate text of all runs
        StringBuilder sb = new StringBuilder();
        for (XWPFRun r : p.getRuns()){
            int pos = r.getTextPosition();
            if(r.getText(pos) != null) {
                sb.append(r.getText(pos));
            }
        }

        // Continue if there is text and contains "test"
        if(sb.length() > 0 && sb.toString().contains("test")) {
            // Remove all existing runs
            for(int i = numberOfRuns; i >=0 ; i--) {
                p.removeRun(i);
            }
            String text = sb.toString().replace("test", "DOG");
            // Add new run with updated text
            XWPFRun run = p.createRun();
            run.setText(text);
            p.addRun(run);
        }
    }
   doc.write(new FileOutputStream(outpath));
}
}