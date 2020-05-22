public class Demo {

    public static void main(String[] args) throws Exception {
        JAXBContext jc = JAXBContext.newInstance(Span.class);

        Unmarshaller unmarshaller = jc.createUnmarshaller();
        Span span = (Span) unmarshaller.unmarshal(new StringReader("<span>Text<div>Text2</div>Text3</span>"));
        System.out.println(span.getItems());

        Marshaller marshaller = jc.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(span, System.out);
    }

}