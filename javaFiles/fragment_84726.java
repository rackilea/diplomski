...
import java.io.File;
import java.io.InputStream;
import java.util.Iterator;
//import org.apache.poi.ooxml.util.SAXHelper;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.model.SharedStringsTable;
import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import javax.xml.parsers.SAXParserFactory;
import javax.xml.parsers.SAXParser;
...

...
        OPCPackage opcPackage = OPCPackage.open(file);
        XSSFReader xssfReader = new XSSFReader(opcPackage);
        SharedStringsTable sharedStringsTable = xssfReader.getSharedStringsTable();

        //XMLReader xmlParser = SAXHelper.newXMLReader();
        SAXParserFactory parserFactory = SAXParserFactory.newInstance();
        SAXParser parser = parserFactory.newSAXParser();
        XMLReader xmlParser = parser.getXMLReader();
        ContentHandler contentHandler = new SAXExcelSheetHandler(sharedStringsTable);
        xmlParser.setContentHandler(contentHandler);
...