import java.io.IOException;

import javax.swing.text.BadLocationException;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDTextbox;
import org.junit.Test;

public class TestPDTextbox {
    @Test
    public void Sample1 () throws IOException, COSVisitorException, BadLocationException {


        PDDocument doc = new PDDocument();
        PDPage page = new PDPage();
        doc.addPage(page);   

        PDFont font = PDType1Font.HELVETICA;
        PDResources res = new PDResources();
        String fontName = res.addFont(font);
        String defaultAppearance = "/"+fontName+" 7 Tf 0 g";

        COSDictionary acroFormDict = new COSDictionary(); 
        acroFormDict.setBoolean(COSName.getPDFName("NeedAppearances"), false);
        acroFormDict.setItem(COSName.getPDFName("Fields"), new COSArray());
        acroFormDict.setItem(COSName.DA, new COSString(defaultAppearance));

        PDAcroForm acroForm = new PDAcroForm(doc, acroFormDict);
        acroForm.setDefaultResources(res);

        doc.getDocumentCatalog().setAcroForm(acroForm);

        COSDictionary cosDict1 = new COSDictionary();
        COSArray rect1 = new COSArray();
        rect1.add(new COSFloat(100));
        rect1.add(new COSFloat(700));
        rect1.add(new COSFloat(200));
        rect1.add(new COSFloat(750));

        cosDict1.setItem(COSName.RECT, rect1);
        cosDict1.setItem(COSName.FT, COSName.getPDFName("Tx")); // Field Type
        cosDict1.setItem(COSName.TYPE, COSName.ANNOT);
        cosDict1.setItem(COSName.SUBTYPE, COSName.getPDFName("Widget"));
        cosDict1.setItem(COSName.T, new COSString("tx1"));
        cosDict1.setItem(COSName.DA, new COSString(defaultAppearance));
//        cosDict1.setItem(COSName.V, new COSString("Test Value1"));

        PDTextbox textbox = new PDTextbox(doc.getDocumentCatalog().getAcroForm(), cosDict1);

      textbox.setValue("Test Value");

        page.getAnnotations().add(textbox.getWidget());
        acroForm.getFields().add(textbox);

         doc.save("C:\\PDF\\SampleTextbox.pdf");
         doc.close();
    }
}