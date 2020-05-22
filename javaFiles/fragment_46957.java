import java.io.InputStream;
import java.util.ArrayList;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.apache.commons.lang3.time.StopWatch;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class ExcelToStringArray implements Cloneable {

    public static ArrayList<ArrayList<StringBuilder>> stringArrayToReturn = new ArrayList<ArrayList<StringBuilder>>();
    public static ArrayList<StringBuilder> retainedString;
    public static Integer lineCounter = 0;

    public ArrayList<ArrayList<StringBuilder>> GetSheetInStringArray(String PathtoFilename, String rId)
            throws Exception {
        ExcelToStringArray myParser = new ExcelToStringArray();
        myParser.processOneSheet(PathtoFilename, rId);
        return stringArrayToReturn;
    }

    public void processOneSheet(String PathtoFilename, String rId) throws Exception {
        OPCPackage pkg = OPCPackage.open(PathtoFilename);
        XSSFReader r = new XSSFReader(pkg);
        SharedStringsTable sst = r.getSharedStringsTable();

        XMLReader parser = fetchSheetParser(sst);

        InputStream sheet = r.getSheet(rId);
        InputSource sheetSource = new InputSource(sheet);
        parser.parse(sheetSource);
        sheet.close();
    }

    public XMLReader fetchSheetParser(SharedStringsTable sst) throws SAXException {
        XMLReader parser = XMLReaderFactory.createXMLReader("org.apache.xerces.parsers.SAXParser");
        ContentHandler handler = new SheetHandler(sst);
        parser.setContentHandler(handler);
        return parser;
    }

    private class SheetHandler extends DefaultHandler {
        private SharedStringsTable sst;
        private String lastContents;
        private boolean nextIsString;

        private SheetHandler(SharedStringsTable sst) {
            this.sst = sst;
        }

        public void startElement(String uri, String localName, String name, Attributes attributes) throws SAXException {

            if (name.equals("row")) {
                retainedString = new ArrayList<StringBuilder>();

                if (retainedString.isEmpty()) {
                    stringArrayToReturn.add(retainedString);
                    retainedString.clear();
                }

                System.out.println("New row begins");

                retainedString.add(new StringBuilder(lineCounter.toString()));
                lineCounter++;
            }
            // c => cell
            if (name.equals("c")) {
                // Print the cell reference
                System.out.print(attributes.getValue("r") + " - ");

                // System.out.print(attributes.getValue("r") + " - ");
                // Figure out if the value is an index in the SST
                String cellType = attributes.getValue("t");
                if (cellType != null && cellType.equals("s")) {
                    nextIsString = true;
                } else {
                    nextIsString = false;
                }
            }
            // Clear contents cache
            lastContents = "";
        }

        public void endElement(String uri, String localName, String name) throws SAXException {
            // Process the last contents as required.
            // Do now, as characters() may be called more than once
            if (nextIsString) {
                int idx = Integer.parseInt(lastContents);
                lastContents = new XSSFRichTextString(sst.getEntryAt(idx)).toString();
                nextIsString = false;
            }

            // v => contents of a cell
            // Output after we've seen the string contents
            if (name.equals("v")) {
                System.out.println(lastContents);
                // value of cell what it string or number
                retainedString.add(new StringBuilder(lastContents));
            }
        }

        public void characters(char[] ch, int start, int length) throws SAXException {
            lastContents += new String(ch, start, length);
        }
    }

    public static void main(String[] args) throws Exception {
        StopWatch watch = new StopWatch();
        watch.start();
        ExcelToStringArray generate = new ExcelToStringArray();
        // rID1 is first sheet in my workbook for rId2 for second sheet and so
        // on.
        generate.GetSheetInStringArray("D:\\Users\\NIA\\Desktop\\0000_MasterTestSuite.xlsx", "rId10");

        watch.stop();

        System.out.println(DurationFormatUtils.formatDurationWords(watch.getTime(), true, true));
        System.out.println("done");
        System.out.println(generate.stringArrayToReturn);

    }

}