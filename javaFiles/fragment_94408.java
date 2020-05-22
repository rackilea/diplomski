@Getter
@Setter
public class Name {

    @JsonDeserialize(using = StringHashMapValueDeserializer.class)
    Map<String, String> stuff;

    @Override
    public String toString() {
        return "Name [stuff=" + stuff + "]";
    }
}