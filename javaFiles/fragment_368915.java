import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;`
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ReadWrite {
int rownum = 1;
HSSFSheet firstSheet;
Collection<File> files;
HSSFWorkbook workbook;
File exactFile;
boolean retu;
// BufferedReader reader = null;
{
workbook = new HSSFWorkbook();
    firstSheet = workbook.createSheet("SampleSheet");
    Row headerRow = firstSheet.createRow(0);
    // headerRow.createCell(0).setCellValue("#");
  headerRow.createCell(0).setCellValue("ID");
    headerRow.createCell(1).setCellValue(Message");
    headerRow.createCell(2).setCellValue("name");
    headerRow.createCell(3).setCellValue("address");
    headerRow.createCell(4).setCellValue("contact");
    headerRow.createCell(5).setCellValue("Next");
    headerRow.createCell(6).setCellValue("Prev");
}
public static void main(String args[]) {
    ReadWrite class2 = new ReadWrite();
    class2.readfile();
}
void readfile() {
    try {

FileInputStream fInput = new FileInputStream(
                "D:\\Rahul\\rahul1.txt");

        DataInputStream dis = new DataInputStream(fInput);

        BufferedReader br = new BufferedReader(new InputStreamReader(dis));

        String lineStr;
        String prevStr = "";
        String nextStr = "";
        //List<String> l1 = new ArrayList<String>();
        int i;
        int seqno = 1;

        while ((lineStr = br.readLine()) != null) {
            List<String> l1 = new ArrayList<String>();
            if (lineStr.contains("Oracle")
                    || lineStr.contains("SAP")
                    || lineStr.contains("J2EE")) {


                l1.add("C1");
                l1.add(lineStr);
                l1.add("M1");
                l1.add("R1");
                l1.add("V1");
                l1.add(nextStr);
                l1.add(prevStr);

            } else {
                prevStr = lineStr;
            }

            try {
                if (l1 != null && l1.size() > 0)
                    retu = writenameinsheet(l1);
            } catch (Exception e) {
                e.printStackTrace();
            }
            seqno++;
            i = 1;
        }br.close();


            FileOutputStream fos = null;
            try {
                File excelFile = new File("D:\\Rahul\\rahul.xls");
                fos = new FileOutputStream(excelFile);
                workbook.write(fos);
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fos != null) {
                    try {
                        fos.flush();
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }

    } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    } finally {
    }

}

boolean writenameinsheet(List<String> l1) throws Exception {

    try {
        Row row = firstSheet.createRow(rownum);
        for (int j = 0; j < l1.size(); j++){

            Cell cell = row.createCell(j);
            cell.setCellValue(l1.get(j));

        }rownum++;

    } catch (Exception e) {
        e.printStackTrace();
    } finally {
    }
    return true;

}