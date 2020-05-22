public class JacksonJAXBElement {
    // a mixin annotation that overrides the handling for the JAXBElement
    public static interface JAXBElementMixin {
        @JsonValue
        Object getValue();
    }

    public static void main(String[] args) throws JAXBException, JsonProcessingException {
        ObjectFactory factory = new ObjectFactory();
        Thing thing = factory.createThing();
        thing.setString("value");
        thing.setNumber(123);
        JAXBElement<Thing> orderJAXBElement = factory.createItem(thing);

        System.out.println("XML:");
        JAXBContext jc = JAXBContext.newInstance(Thing.class);
        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        marshaller.marshal(orderJAXBElement, System.out);
        System.out.println("JSON:");

        ObjectMapper mapper = new ObjectMapper();
        mapper.addMixInAnnotations(JAXBElement.class, JAXBElementMixin.class);
        System.out.println(mapper.writerWithDefaultPrettyPrinter()
                .writeValueAsString(orderJAXBElement));
    }
}