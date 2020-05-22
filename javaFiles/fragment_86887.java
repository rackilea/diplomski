// Modified test program
public class XmlTest {
    public static void main(String[] args) {
        ErrorFinder errorFinder = new ErrorFinder(0); // Create our own content handler
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser parser = spf.newSAXParser();
            XMLReader reader = parser.getXMLReader();
            reader.setContentHandler(errorFinder); // Use instead of the default handler
            reader.setErrorHandler(new XmlErrorHandler());
            InputSource is = new InputSource(args[0]);
            reader.parse(is);
        }
        catch (SAXException e) {      // Useful error case
            System.err.println(e);
            e.printStackTrace(System.err);
        }
        catch (Exception e) {         // Useless error case arrives here
            System.err.println(e);
            e.printStackTrace();
            // Option 1: repeat parsing (see above) with a new ErrorFinder initialised thus:
            ErrorFinder ef2 = new ErrorFinder(errorFinder.getCurrentLineNumber()); // and
            is.setEncoding("Windows-1252");
        }
    }
}

// Content handler with irrelevant method implementations elided.
public class ErrorFinder implements ContentHandler {
    private int lineNumber; // If non-zero, the line number to retrieve characters for.
    private int currentLineNumber;
    private char[] chars;
    private Locator locator;

    public ErrorFinder(int lineNumber) {
        super();
        this.lineNumber = lineNumber;
    }

    public void setDocumentLocator(Locator locator) {
        this.locator = locator;
    }

    @Override
    public void startDocument() throws SAXException {
        currentLineNumber = locator.getLineNumber();
    }

    ... // Skip other over-ridden methods as they have same code as startDocument().

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        currentLineNumber = locator.getLineNumber();
        if (currentLineNumber == lineNumber) {
            char[] c = new char[length];
            System.arraycopy(ch, start, c, 0, length);
            chars = c;
        }
    }

    public int getCurrentLineNumber() {
        return currentLineNumber;
    }

    public char[] getChars() {
        return chars;
    }
}