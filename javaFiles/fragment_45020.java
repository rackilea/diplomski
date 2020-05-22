public class MyFirstTika {

      public static boolean contains(File file, String s) throws MalformedURLException, 
         IOException, MimeTypeException, SAXException, TikaException{

        ContentHandler handler = new BodyContentHandler();

        MimeTypes mimeRegistry = TikaConfig.getDefaultConfig().getMimeRepository();

        Detector mimeDetector = (Detector) mimeRegistry;

        LanguageIdentifier lang = new LanguageIdentifier(new LanguageProfile(FileUtils.readFileToString(file)));

        Parser parser = TikaConfig.getDefaultConfig().getParser(MediaType.parse(mimeRegistry.getMimeType(file).getName()));

        Metadata parsedMet = new Metadata();

        parser.parse(file.toURI().toURL().openStream(), handler,parsedMet, new ParseContext());

        System.out.println("Handler:\n\n******" + handler + "\n\n*****" );
        return handler.toString().toLowerCase().contains(s.toLowerCase());
      }

      public static void main(String[] args) throws Exception 
      {
        String searchString = "champion";
        String filename = "schedule.pdf"; //test.docx";//"meds.xlsx";//Test2.Doc";
        File file = new File(filename);

        System.out.println(file + " contains " + searchString + ": " 
                + contains(file, searchString));
        }
    }