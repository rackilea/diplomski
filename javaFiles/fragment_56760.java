package stackoverflow;

import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.color.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.IElement;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ITextForDummiesFacade 
{

    // iText IO
    private PdfDocument pdfDocument;
    private Document layoutDocument;

    // font sizes
    private float regularFontSize = 12f;
    private float chapterTitleFontSize = 14f;

    // font colors
    private Color chapterFontColor = new DeviceRgb(249, 157, 37);
    private Color regularFontColor = new DeviceRgb(100, 100, 100);

    // structure
    private Map<String, Integer> chapterNames = new HashMap<>();
    private Map<Integer, List<IElement>> elementsPerChapter = new HashMap<>();

    public ITextForDummiesFacade(OutputStream os) throws IOException 
    {
        this.pdfDocument = new PdfDocument(new PdfWriter(os));
        this.layoutDocument  = new Document(pdfDocument);
    }

    public ITextForDummiesFacade(File outputFile) throws IOException 
    {
        this.pdfDocument = new PdfDocument(new PdfWriter(outputFile));
        this.layoutDocument  = new Document(pdfDocument);
    }

    public boolean createChapter(String title)
    {
        if(chapterNames.containsKey(title))
            return false;
        int nextID = chapterNames.size();
        chapterNames.put(title, nextID);
        elementsPerChapter.put(nextID, new ArrayList<IElement>());
        elementsPerChapter.get(nextID).add(new Paragraph(title)
            .setFontSize(chapterTitleFontSize)
            .setFontColor(chapterFontColor));
        return true;
    }

    public boolean addPlainText(String chapter, String text)
    {
        if(!chapterNames.containsKey(chapter))
            return false;
        int ID = chapterNames.get(chapter);
        elementsPerChapter.get(ID).add(new Paragraph(text)
            .setFontSize(regularFontSize)
            .setFontColor(regularFontColor));
        return true;
    }

    public boolean addHTML(String chapter, String HTML)
    {
        if(!chapterNames.containsKey(chapter))
            return false;
        int ID = chapterNames.get(chapter);
        try 
        {
    elementsPerChapter.get(ID).addAll(HtmlConverter.convertToElements(HTML));
        } catch (IOException e) 
        {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean addImage(String chapter, byte[] image)
    {
        if(!chapterNames.containsKey(chapter))
            return false;
        int ID = chapterNames.get(chapter);
        elementsPerChapter.get(ID).add(new Image(ImageDataFactory.create(image)));
        return true;
    }

    private void write()
    {
        for(int i=0;i<chapterNames.size();i++)
        {
            for(IElement e : elementsPerChapter.get(i))
                if(e instanceof IBlockElement)
                    layoutDocument.add((IBlockElement) e);
        }
    }

    public void close()
    {
        write();
        layoutDocument.flush();
        layoutDocument.close();
    }
}