import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class TableWidthSample {

    public static void main(String[] args) {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream("TableColumnWidth.pdf"));
            document.open();

            PdfPTable table = createTableWithRelativeColumnWidths();

            // needed for calculation of getAbsoluteWidths: (A) totalWidth is set for table
            table.setTotalWidth(calculateTableWidthBasedOnPageA4(document, table));
            // now it prints width, because (A)
            printTableWidth(table, "after totalWidth set manually"); // absoluteWidths: [134.4857, 14.942857, 268.9714]

            // long text, that needs to be split among cells (fullAlamatPP)
            String text = "this is a very long text. The text contains a full address. Because the text is too long to be shown in the last cell, it is split.";
            // your CODE to fill text into cells based on restrictions
            addTextAcrossTableCells(table, text);

            document.add(table);

/*
            // need to add filled table to doc (B)
            addToDocumentCellsAndTable(document, table);
            // now it prints width, because (B)
            printTableWidth(table, "after added to doc"); // absoluteWidths: [134.4857, 14.942857, 268.9714]
*/
            document.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static PdfPTable createTableWithRelativeColumnWidths() {
        float[] relativeWidths = {4.5F, 0.5F, 9F};
        PdfPTable table = new PdfPTable(relativeWidths);
        table.setWidthPercentage(100F);
        printTableWidth(table, "after table created"); // absoluteWidths: [0.0, 0.0, 0.0]
        return table;
    }

    private static float calculateTableWidthBasedOnPageA4(Document document, PdfPTable table) {
        return (PageSize.A4.getWidth() - document.leftMargin() - document.rightMargin())
                * table.getWidthPercentage() / 100;
    }

    private static void addToDocumentCellsAndTable(Document document, PdfPTable table) throws DocumentException {
        // needed for calculation of getAbsoluteWidths: (B.1) add cells to table
        table.addCell("Hello");
        table.addCell("World");
        table.addCell("!");
        printTableWidth(table, "after cells added to table"); // absoluteWidths: [0.0, 0.0, 0.0]

        // needed for calculation of getAbsoluteWidths: (B.2) add table to doc
        document.add(table);
    }

    private static void addTextAcrossTableCells(PdfPTable table, String text) throws IOException, DocumentException {
        // restrictions; this is width of a column from table
        float maxColumnWidth = table.getAbsoluteWidths()[2]; // 330.12103F;
        System.out.println("use width of third column as max: " + maxColumnWidth);
        // sample font used for calculation of text-width
        Font font = new Font(BaseFont.createFont("Courier", BaseFont.CP1250, true), 12);

        // alamatSesuaiKtpPP
        String splitText[] = getTextPartsUsingFontWithMaxWidth(text, font, maxColumnWidth);
        String dottedLine = "..";
        table.addCell("Alamat / Address:");

        // p_alamat1_ct
        Phrase phrase1 = new Phrase(splitText[0], font);
        phrase1.add(dottedLine);
        PdfPCell cell1 = new PdfPCell(phrase1);
        cell1.setBackgroundColor(BaseColor.LIGHT_GRAY);
        cell1.setBorder(PdfPCell.NO_BORDER);
        table.addCell(cell1);

        // p_alamat2_ct
        Phrase phrase2 = new Phrase(splitText[1], font);
        phrase2.add(dottedLine);
        PdfPCell cell2 = new PdfPCell(phrase2);
        cell2.setBorder(PdfPCell.NO_BORDER);
        table.addCell(cell2);
    }

    private static String[] getTextPartsUsingFontWithMaxWidth(String text, Font font, float maxWidth) {
        String results[] = new String[] {"",""};
        String firstPartOfText = " ";
        float widthOfText = 0;
        for (int i = 0; i < text.length();i++) {
            firstPartOfText += text.charAt(i);
            widthOfText = font.getCalculatedBaseFont(true).getWidthPoint(firstPartOfText, font.getCalculatedSize());
            System.out.printf("%d: widthOfText: %f\n", i, widthOfText);
            if (widthOfText > maxWidth) {
                results[0] = firstPartOfText.substring(0, firstPartOfText.length() - 1);
                results[1] = text.substring(i); // second argument "text.length()" is not needed
                break;
            }
        }

        if (results[0] == "") {
            results[0] = text;
        }
        return results;
    }

    private static void printTableWidth(PdfPTable table, String labelText) {
        float[] absoluteWidths = table.getAbsoluteWidths();
        System.out.println(labelText + "> getAbsoluteWidths: " + Arrays.toString(absoluteWidths));
    }
}