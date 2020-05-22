public class PDFWriter {

public static final String testDir = "C:\\pdftest\\"; 
public static final String adobePath = "\"C:\\Program Files\\Adobe\\Reader 10.0\\Reader\\AcroRd32.exe\"";

public static void main(String[] args){

    try {
        new PDFWriter().run();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

public void run() throws Exception {
    InputStream in = this.getClass().getResourceAsStream("/resources/test.pdf");
    new File(testDir).mkdirs();
    String pdfFilePath = testDir + "test.pdf";
    FileOutputStream out = new FileOutputStream (pdfFilePath);
    byte[] buffer = new byte[1024];
    int len = in.read(buffer);
    while (len != -1) {
        out.write(buffer, 0, len);
        len = in.read(buffer);
    }
    out.close();

    Runtime rt = Runtime.getRuntime();
    String command = adobePath + " " + pdfFilePath;
    rt.exec(command);
}

}