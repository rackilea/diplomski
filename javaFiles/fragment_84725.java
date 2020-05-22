...
import org.apache.poi.xssf.usermodel.XSSFRichTextString;
...

...
    public void endElement(String uri, String localName, String name)
            throws SAXException {
        // Process the last contents as required.
        // Do now, as characters() may be called more than once
        if(nextIsString) {
            int idx = Integer.parseInt(lastContents);
            //lastContents = sst.getItemAt(idx).getString();
            lastContents = new XSSFRichTextString(sst.getEntryAt(idx)).toString();
            nextIsString = false;
        }

        // v => contents of a cell
        // Output after we've seen the string contents
        if(name.equals("v")) {
            System.out.println(lastContents);
        }
    }

...