@XmlRootElement(name = "com.main.module.Test")
class Foo {
    @XmlElement(name = "com.main.module.sample")
    String bar;

    public static void main(String[] args) throws Exception {
        Foo foo = new Foo();
        foo.bar = "Hello World";

        Marshaller marshaller = JAXBContext.newInstance(Foo.class).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(foo, System.out);
    }
}