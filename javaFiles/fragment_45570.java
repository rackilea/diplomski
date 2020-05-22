@Test
public void tryIt() throws Exception {
    JAXBContext context = JAXBContext.newInstance(Request.class, DerivedFoo.class, DerivedBar.class);

    Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

    Request request = new Request();
    DerivedFoo foo = new DerivedFoo();
    request.foo = foo;
    foo.bar = new ArrayList<DerivedBar>();
    foo.bar.add(new DerivedBar());

    marshaller.marshal(request, System.out);
}