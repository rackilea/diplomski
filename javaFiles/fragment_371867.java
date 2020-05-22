public class Test {
    public static void main(String[] args) throws Exception {
        Marshaller marshaller = JAXBContext.newInstance(NodeMapDTO.class).createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(new NodeMapDTO(new IPAddressDTO("192.59.233.20")), System.out);
    }
}