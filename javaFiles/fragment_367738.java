import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.ss.util.*;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.streaming.*;

class CreateSXSSFWorkbookDataValidations {

    public static void main(String[] args) throws Exception {

        SXSSFWorkbook workbook = new SXSSFWorkbook(100);
        SXSSFSheet sheet = workbook.createSheet();

        String[] optionsArray = new String[] {"1000.00","2000.00"};

        int no_of_rows = 50000;

        for(int i=0;i<=no_of_rows;i++) {
            SXSSFRow row1 = sheet.createRow(i);
            SXSSFCell r1c1 = row1.createCell(0);
            r1c1.setCellValue("1000.00");   
            SXSSFCell r1c2 = row1.createCell(1);
            r1c2.setCellValue("2000.00");
        }

        DataValidationConstraint constraint1 = sheet.getDataValidationHelper().createExplicitListConstraint(optionsArray);
        CellRangeAddressList addressList1 = new CellRangeAddressList(0, no_of_rows, 0, 0);
        DataValidation dataValidation1 = sheet.getDataValidationHelper().createValidation(constraint1, addressList1);
        sheet.addValidationData(dataValidation1);

        DataValidationConstraint constraint2 = sheet.getDataValidationHelper().createExplicitListConstraint(optionsArray);
        CellRangeAddressList addressList2 = new CellRangeAddressList(0, no_of_rows, 1, 1);
        DataValidation dataValidation2 = sheet.getDataValidationHelper().createValidation(constraint2, addressList2);
        sheet.addValidationData(dataValidation2);

        FileOutputStream fos = new FileOutputStream(new File("testout.xlsx"));
        workbook.write(fos);
        workbook.close();
        fos.close();


    }
}