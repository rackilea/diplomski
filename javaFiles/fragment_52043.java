public class ExampleHandler extends DefaultHandler{

 // ===========================================================
 // Fields
 // ===========================================================

 private StringBuilder mStringBuilder = new StringBuilder();

 private ParsedExampleDataSet mParsedExampleDataSet = new ParsedExampleDataSet();
 private List<ParsedExampleDataSet> mParsedDataSetList = new ArrayList<ParsedExampleDataSet>();

 // ===========================================================
 // Getter & Setter
 // ===========================================================

 public List<ParsedExampleDataSet> getParsedData() {
      return this.mParsedDataSetList;
 }

 // ===========================================================
 // Methods
 // ===========================================================

 /** Gets be called on opening tags like:
  * <tag>
  * Can provide attribute(s), when xml was like:
  * <tag attribute="attributeValue">*/
 @Override
 public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
    if (localName.equals("PhonebookEntry")) {
        this.mParsedExampleDataSet = new ParsedExampleDataSet();
    }

 }

 /** Gets be called on closing tags like:
  * </tag> */
 @Override
 public void endElement(String namespaceURI, String localName, String qName)
           throws SAXException {
      if (localName.equals("PhonebookEntry")) {
           this.mParsedDataSetList.add(mParsedExampleDataSet);
      }else if (localName.equals("firstname")) {
           mParsedExampleDataSet.setfirstname(mStringBuilder.toString().trim());
      }else if (localName.equals("lastname"))  {
          mParsedExampleDataSet.setlastname(mStringBuilder.toString().trim());
      }else if(localName.equals("Address"))  {
          mParsedExampleDataSet.setAddress(mStringBuilder.toString().trim());
      }
      mStringBuilder.setLength(0);
 }

 /** Gets be called on the following structure:
  * <tag>characters</tag> */
 @Override
public void characters(char ch[], int start, int length) {
      mStringBuilder.append(ch, start, length);
}
}