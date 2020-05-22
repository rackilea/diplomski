@GET
@Produces(MediaType.TEXT_XML)
public List<JAXBElement<String>> stringlist() {
     Arrays.asList(new JAXBElement[] {
        new JAXBElement(QName.valueOf("element1"), String.class, "ahoj"),
        new JAXBElement(QName.valueOf("element2"), String.class, "nazdar")
    };);
}