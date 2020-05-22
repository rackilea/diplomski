import java.nio.file.Files;
import java.nio.file.Path;

...

String contentType = Files.probeContentType(outputFile.toPath());
if(contentType.equals("application/pdf"))
{
       PDDocument document = null; 
    document = PDDocument.load(outputFile);
    document.getClass();
    if( !document.isEncrypted() ){
        PDFTextStripperByArea stripper = new PDFTextStripperByArea();
        stripper.setSortByPosition( true );
        PDFTextStripper Tstripper = new PDFTextStripper();
        String st = Tstripper.getText(document);
        textArea.setValue(st);
    }
    }catch(Exception e){
        e.printStackTrace();
    }

}
else if(contentType.equals("text/plain"))
{
                try {
                    BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(outputFile.getAbsolutePath()), StandardCharsets.UTF_8));
                    String line;
                    while ((line = reader.readLine()) != null)
                    {
                        textArea.setValue(textArea.getValue() + "\n" + line);
                    }
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

}