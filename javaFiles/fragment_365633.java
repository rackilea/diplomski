public class SalesRepbyId implements 
DataParserImplementation<Map<String,ObjectImplementation>> {
    private FileParserImplementation<ArrayList<String[]>> FileParser;
    //the Factory class that creates instances of the reflected class I wanted
    private ObjectFactory Factory = new ObjectFactory();

    public Map<String, ObjectImplementation> Parse() {
        //the proeprties object which then loads properties from a file and reflects the classtype I want
        Properties prop = new Properties();
        //loading in the classtype and casting it to the subclass of ObjectImplementation that it actually is
        prop.load(SalesRepbyId.class.getResourceAsStream("config.properties"));
        Class<? extends ObjectImplementation> Classtouse = Class.forName(prop.getProperty("ObjectImplementation")).asSubclass(ObjectImplementation.class);
        //construct instances of 'Classtouse' and parse the data into these dynamically typed objects
        //return the map that holds these objects
        }