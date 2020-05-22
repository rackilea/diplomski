package sandbox.barcodes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class BarcodeInTable {
    public static final String DEST = "/tmp/barcode_in_table.pdf";

    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        file.getParentFile().mkdirs();
        new BarcodeInTable().createPdf(DEST);
    }
    public void createPdf(String dest) throws IOException, DocumentException {
        Document document = new Document();
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(dest));
        document.open();

        String withFNC1 = "021930063300597615160221105052013760";
        String withoutFNC1 = "02193006330059761516022110505201Ê3760";

        PdfContentByte cb = writer.getDirectContent();
        PdfPTable table = new PdfPTable(2);

        table.addCell("Without FNC1");
        Barcode128 code128 = new Barcode128();
        code128.setCode(withFNC1);
        code128.setCodeType(Barcode128.CODE128);
        Image code128Image = code128.createImageWithBarcode(cb, null, null);
        PdfPCell cell = new PdfPCell(code128Image);
        table.addCell(cell);

        table.addCell("With FNC1");
        code128 = new Barcode128();
        code128.setCode(withoutFNC1);
        code128.setCodeType(Barcode128.CODE128);
        code128Image = code128.createImageWithBarcode(cb, null, null);
        cell = new PdfPCell(code128Image);
        table.addCell(cell);
        document.add(table);

        document.close();
    }

}