public static class Base {
    private String name ;

    @XmlElement(name = "name")
    public String getName() {
        return name;
    }

    public Base setName(String name) {
        this.name = name;
        return this;
    }
}

public static void main (String [] args) throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(Base.class);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    JAXBElement<Base> basea = unmarshaller.unmarshal(new StreamSource(new StringReader("<RootA><name>nanana</name></RootA>")), Base.class);
    System.out.println(basea.getValue().getName());
    JAXBElement<Base> baseb = unmarshaller.unmarshal(new StreamSource(new StringReader("<RootB><name>nbnbnb</name></RootB>")), Base.class);
    System.out.println(baseb.getValue().getName());
}