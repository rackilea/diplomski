public class Main {

    public static void main(String[] args) {
        Book book = new Book();
        book.title = "hello";

        JAXBContext context;
        try {
            context = JAXBContextFactory.createContext(new Class[] {Book.class}, null);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(MarshallerProperties.MEDIA_TYPE, "application/json");
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(book, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}