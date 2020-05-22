interface BookSerializerStrategy {
    String serialize(Book book);
}

public class XmlBookSerializerStrategy implements BookSerializerStrategy {

    public String serialize(Book book) {
        // Do something to serialize your book.
    }

}

public class JsonBookSerializerStrategy implements BookSerializerStrategy {

    public String serialize(Book book) {
        // Do something to serialize your book.
    }

}