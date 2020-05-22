public static void main(final String[] args)
        throws IOException {
    XmlMapper xmlMapper = new XmlMapper();
    xmlMapper.registerModule(new JaxbAnnotationModule());

    Foo foo = new Foo();
    foo.items = Arrays.asList(1, 2.5f);

    String xml = xmlMapper.writeValueAsString(foo);
    System.out.println(xml);

    xml = 
            "<Foo>    \n" + 
            "    <A> 1 </A>\n" +
            "    <B> 2.5 </B>\n" + 
            "</Foo>";

    foo = xmlMapper.readValue(xml, Foo.class);
}

public static class Foo {

    @JacksonXmlElementWrapper(useWrapping = false)
    @XmlElements({ 
        @XmlElement(name = "A", type = Integer.class),
        @XmlElement(name = "B", type = Float.class) 
    })
    public List items;
}