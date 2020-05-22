public static void main(final String[] args)
        throws JAXBException {
    JAXBContext jaxbContext = JAXBContext.newInstance(Foo.class);

    String xml = 
            "<Foo>    \n" + 
            "    <A> 1 </A>\n" +
            "    <B> 2.5 </B>\n" +
            "</Foo>";

    StringReader sr = new StringReader(xml);
    Foo foo = (Foo) jaxbContext.createUnmarshaller().unmarshal(sr);
    System.out.println(foo.items);

    StringWriter sw = new StringWriter();
    jaxbContext.createMarshaller().marshal(foo, sw);
    System.out.println(sw);
}

@XmlRootElement(name = "Foo")
public static class Foo {

    @XmlElements({ 
        @XmlElement(name = "A", type = Integer.class),
        @XmlElement(name = "B", type = Float.class) 
    })
    public List items;
}