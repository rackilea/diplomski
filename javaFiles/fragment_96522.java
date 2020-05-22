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

@XmlRootElement( name = "RootA")
public static class RootA extends Base{ 
}

@XmlRootElement( name = "RootB")
public static class RootB extends Base {
}


public static void main (String [] args) throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(RootA.class,RootB.class);
    Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
    RootA rootA = (RootA)unmarshaller.unmarshal(new StringReader("<RootA><name>nanana</name></RootA>"));
    System.out.println(rootA.getName());
    RootB rootB = (RootB)unmarshaller.unmarshal(new StringReader("<RootB><name>nbnbnb</name></RootB>"));
    System.out.println(rootB.getName());
}