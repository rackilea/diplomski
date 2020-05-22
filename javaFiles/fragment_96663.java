import java.io.*;
import java.net.URL;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.*;
import org.apache.poi.util.IOUtils;

public class EmbeddedPdfInExcel {
    public static void main(String[] args) throws Exception {
        NPOIFSFileSystem fs = new NPOIFSFileSystem(new URL("http://jamesshaji.com/sample.xls").openStream());
        HSSFWorkbook wb = new HSSFWorkbook(fs.getRoot(), true);
        for (HSSFObjectData obj : wb.getAllEmbeddedObjects()) {
            String oleName = obj.getOLE2ClassName();
            DirectoryNode dn = (DirectoryNode)obj.getDirectory();
            if(oleName.contains("Acro") && dn.hasEntry("CONTENTS")){
                InputStream is = dn.createDocumentInputStream("CONTENTS");
                FileOutputStream fos = new FileOutputStream(obj.getDirectory().getName()+".pdf");
                IOUtils.copy(is, fos);
                fos.close();
                is.close();
            }
        }
        fs.close();
    }
}