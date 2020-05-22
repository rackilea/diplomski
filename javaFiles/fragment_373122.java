import javax.xml.stream.*;
import java.io.*;
import java.util.zip.*;

public class ConvertToUtf8 {

  public static void main(String[] args) {
    System.setProperty("entityExpansionLimit", "10000000");
    XMLInputFactory inputFactory = XMLInputFactory.newFactory();
    XMLOutputFactory outputFactory = XMLOutputFactory.newFactory();

    try (
        FileInputStream ifs = new FileInputStream("dblp-2018-08-01.xml.gz"); 
        GZIPInputStream gzIn = new GZIPInputStream(ifs);
        FileOutputStream ofs = new FileOutputStream("dblp_utf8.xml.gz");
        GZIPOutputStream gzOut = new GZIPOutputStream(ofs, true);
        ) 
    {
      XMLEventReader inEvt = inputFactory.createXMLEventReader(gzIn);
      XMLEventWriter outEvt = outputFactory.createXMLEventWriter(gzOut, "UTF-8");
      outEvt.add(inEvent);
    } catch (IOException | XMLStreamException e) {
      e.printStackTrace();
    }
  }
}