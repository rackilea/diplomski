import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.record.crypto.Biff8EncryptionKey;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.EncryptionMode;
import org.apache.poi.poifs.crypt.Encryptor;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.util.IOUtils;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EncryptTest {
    public static void main(String[] args) throws Exception {
        encryptHSSF();
        encryptXSSF();

        for (final String file : new String[] {"test.xls","test.xlsx"}) {
            try (Workbook wb = WorkbookFactory.create(new File(file), "pass")) {
                System.out.println(wb.getSheetAt(0).getRow(0).getCell(0).getStringCellValue());
            }
        }
    }

    public static void encryptHSSF() throws IOException, EncryptedDocumentException, InvalidFormatException {
        generateFile("test.xls");

        try (HSSFWorkbook hwb = (HSSFWorkbook)WorkbookFactory.create(new File("test.xls"))) {
            Biff8EncryptionKey.setCurrentUserPassword("pass");
            hwb.write();
        }
    }

    public static void encryptXSSF() throws IOException, GeneralSecurityException {
        generateFile("test.xlsx");

        try (POIFSFileSystem fs = new POIFSFileSystem()) {
            EncryptionInfo info = new EncryptionInfo(EncryptionMode.agile);
            Encryptor enc = info.getEncryptor();
            enc.confirmPassword("pass");

            try (OutputStream os = enc.getDataStream(fs)) {
                try (InputStream is = new FileInputStream("test.xlsx")) {
                    IOUtils.copy(is, os);
                }
            }

            try (FileOutputStream fos = new FileOutputStream("test.xlsx")) {
                fs.writeFilesystem(fos);
            }
        }
    }


    public static void generateFile(final String filename) throws IOException {
        try (Workbook wb = filename.endsWith("x") ? new XSSFWorkbook() : new HSSFWorkbook()) {
            wb.createSheet("test").createRow(0).createCell(0).setCellValue("Test");
            try (FileOutputStream fos = new FileOutputStream(filename)) {
                wb.write(fos);
            }
        }
    }
}