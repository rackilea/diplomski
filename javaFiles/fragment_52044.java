/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle icicle) {
         super.onCreate(icicle);

         /* Create a new TextView to display the parsingresult later. */
         TextView tv = new TextView(this);
         try {
              /* Create a URL we want to load some xml-data from. */
              URL url = new URL("http://somedomain.com/jm/sampleXML.xml");
              URLConnection ucon = url.openConnection();

              /* Create a new ContentHandler and apply it to the XML-Reader*/
              ExampleHandler myExampleHandler = new ExampleHandler();

              //remember to import android.util.Xml
              Xml.parse(url.openStream(), Xml.Encoding.UTF_8, myExampleHandler);


              /* Our ExampleHandler now provides the parsed data to us. */
              List<ParsedExampleDataSet> parsedExampleDataSetList =
                                            myExampleHandler.getParsedData();

              /* Set the result to be displayed in our GUI. */
              for(ParsedExampleDataSet parsedExampleDataSet : parsedExampleDataSetList){
                  tv.append(parsedExampleDataSet.toString());
              }

         } catch (Exception e) {
              /* Display any Error to the GUI. */
              tv.setText("Error: " + e.getMessage());

         }
         /* Display the TextView. */
         this.setContentView(tv);
    }