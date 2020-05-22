public class SerializableStringPair extends Pair<String, String> implements
    Serializable {

    private static final long serialVersionUID = 1L;

    public SerializableStringPair(String first, String second) {
        super(first, second);
    }
}