package sample.pdfbox.example;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.imageio.ImageIO;

import org.apache.pdfbox.cos.COSArray;
import org.apache.pdfbox.cos.COSDictionary;
import org.apache.pdfbox.cos.COSFloat;
import org.apache.pdfbox.cos.COSName;
import org.apache.pdfbox.cos.COSString;
import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDResources;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.common.PDStream;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDPixelMap;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectForm;
import org.apache.pdfbox.pdmodel.graphics.xobject.PDXObjectImage;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceDictionary;
import org.apache.pdfbox.pdmodel.interactive.annotation.PDAppearanceStream;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import org.apache.pdfbox.pdmodel.interactive.form.PDPushButton;

public class MyPushButton2 
{
    public static void main(String arg[])  throws IOException, COSVisitorException
    {
        PDDocument document = new PDDocument();
        PDPage page = new PDPage(PDPage.PAGE_SIZE_LETTER);
        document.addPage(page);

        PDFont font = PDType1Font.HELVETICA;
        PDResources res = new PDResources();
        String fontName = res.addFont(font);
        String da = "/Helv 0 Tf 0 g";

        COSDictionary acroFormDict = new COSDictionary(); 
        acroFormDict.setItem(COSName.FIELDS, new COSArray());
        acroFormDict.setItem(COSName.DA, new COSString(da));

        PDAcroForm acroForm =  new PDAcroForm(document, acroFormDict);
        acroForm.setDefaultResources(res);
        document.getDocumentCatalog().setAcroForm(acroForm);


        float x = 10f;
        float y = page.getMediaBox().getHeight();  
        float yOffset = 15f;
        float yCurrent = y - yOffset;  

     // Create appearance stream for local image
        COSArray rectStream = new COSArray();
        rectStream.add(new COSFloat(0));
        rectStream.add(new COSFloat(0));
        rectStream.add(new COSFloat(25));
        rectStream.add(new COSFloat(25));

        final PDRectangle boundingBox = new PDRectangle(rectStream);
        InputStream imageStream = MyPushButton2.class.getResourceAsStream("/Penguins.jpg");
        BufferedImage bImage = ImageIO.read(imageStream);
        PDXObjectImage image = new PDPixelMap(document,bImage);

        PDResources holderFormResources = new PDResources();
        PDStream holderFormStream = new PDStream(document);
        PDXObjectForm holderForm = new PDXObjectForm(holderFormStream);
        holderForm.setResources(holderFormResources);
        holderForm.setBBox(boundingBox);
        holderForm.setFormType(1);

        PDAppearanceDictionary appearance = new PDAppearanceDictionary();
        appearance.getCOSObject().setDirect(true);
        PDAppearanceStream appearanceStream = new PDAppearanceStream(holderForm.getCOSStream());
        appearance.setNormalAppearance(appearanceStream);

        PDResources innerFormResources = new PDResources();
        PDStream innerFormStream = new PDStream(document);
        PDXObjectForm innerForm = new PDXObjectForm(innerFormStream);
        innerForm.setResources(innerFormResources);
        innerForm.setBBox(boundingBox);
        innerForm.setFormType(1);

        String innerFormName = holderFormResources.addXObject(innerForm, "FRM");

        PDResources imageFormResources = new PDResources();
        PDStream imageFormStream = new PDStream(document);

        PDXObjectForm imageForm = new PDXObjectForm(imageFormStream);
        imageForm.setResources(imageFormResources);
        imageForm.setBBox(boundingBox);
        imageForm.setFormType(1);

        String imageFormName = innerFormResources.addXObject(imageForm, "n");
        String imageName = imageFormResources.addXObject(image, "img");

        String holderFormComment = "q 1 0 0 1 0 0 cm /" + innerFormName + " Do Q \n";
        String innerFormComment = "q q 5 0 0 5 0 0 cm /" + imageFormName + " Do Q\n";
        String imgFormComment = "q 5 0 0 5 0 0 cm /" + imageName + " Do Q\n";

        appendRawCommands(holderFormStream.createOutputStream(), holderFormComment);
        appendRawCommands(innerFormStream.createOutputStream(), innerFormComment);
        appendRawCommands(imageFormStream.createOutputStream(), imgFormComment);

        // Create Pushbutton containing status image
        COSDictionary cosDict = new COSDictionary();
        COSArray rect = new COSArray();
        rect.add(new COSFloat(100));
        rect.add(new COSFloat(500));
        rect.add(new COSFloat(300));
        rect.add(new COSFloat(700));

        cosDict.setItem(COSName.RECT, rect);
        cosDict.setItem(COSName.FT, COSName.getPDFName("Btn")); // Field Type
        cosDict.setItem(COSName.TYPE, COSName.ANNOT);
        cosDict.setItem(COSName.SUBTYPE, COSName.getPDFName("Widget"));
        cosDict.setItem(COSName.T, new COSString("ImageField1"));
        cosDict.setInt(COSName.F, 4);
        cosDict.setInt(COSName.FF, 65536);

        PDPushButton button = new PDPushButton(document.getDocumentCatalog().getAcroForm(), cosDict);
        button.setReadonly(true);

        button.getWidget().setAppearance(appearance);
        page.getAnnotations().add(button.getWidget());                          
        acroForm.getFields().add(button); // Added this line for Tilman's comment

        yCurrent = yCurrent - 20 - yOffset;

        File file = new File("C:\\pdf\\ImageButton.pdf");
        System.out.println("Sample file saved at : " + file.getAbsolutePath());
        document.save(file);
        document.close();
    }

    public static void appendRawCommands(OutputStream os, String commands) throws IOException {
        os.write(commands.getBytes("ISO-8859-1"));
        os.close();
    }

}