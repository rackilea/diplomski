public static void main(String[] args) {
    try {
        final JAXBContext context = JAXBContext.newInstance(Country.class);
        final Marshaller marshaller = context.createMarshaller();
        // Create a stringWriter to hold the XML
        final StringWriter stringWriter = new StringWriter();
        CreateXML xml = new CreateXML();
        Country country = xml.createCountry();
        marshaller.marshal(country, stringWriter);
        // Print out the contents of the stringWriter
        System.out.println(stringWriter.toString());
    } catch (JAXBException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
}
private List<String> createCity(){
    List<String> cities = new ArrayList<String>();
    cities.add("Slough");
    cities.add("Manchestor");
    return cities;
}
private List<State> createState(){
    List<State> states = new ArrayList<State>();
    State state = new State();
    state.setStatName("London");
    state.setCityList(createCity());
    states.add(state);
    return states;
}
private Country createCountry(){
    Country country = new Country("UK", createState());
    return country;
}