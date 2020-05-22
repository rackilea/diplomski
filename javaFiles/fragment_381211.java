public class Book implements Serializable {

    private Long id;
    private BookSerializerStrategy serializer

    public String serialize() {
        return serializer.serialize(this);
    }

    public void setSerializer(BookSerializerStrategy serializer) {
        this.serializer = serializer;
    }
}