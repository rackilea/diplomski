public class Project4 {

  private parser RSSParser;

  public RSSParser getParser() {
     return parser
  }

  public static void main (String [] args) throws IOException, SAXException {

     Project4 p = new Project4();
     XMLReader read = XMLReaderFactory.createXMLReader();
     p.parser= new RSSParser();
     read.setContentHandler(p.parser);
     read.parse("http://feeds.ign.com/ign/games-articles");

     /// loop here and connect up your GUI

  }