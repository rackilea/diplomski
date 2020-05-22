public class DataFieldInt extends DataField<Integer> {

    public DataFieldInt(String name, Integer value) {
        super(new NameAndType<>(name, value));
    }

    public DataFieldInt(String name, String value) {
        super(name, value);
    }

    ...
}