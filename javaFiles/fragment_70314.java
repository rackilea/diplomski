public interface FieldType<T> {
    void addValue(T value);
    ArrayList<T> getValues();
}

public abstract class Field<T> implements FieldType<T>, Serializable {
    private UUID key;
    private String name;
    protected ArrayList<T> values;
    private Integer maxValues;
    private String code;

    public abstract void addValues();

    public ArrayList<T> getValues(){
        return this.values;
    }
}

public class FloatField extends Field<Float> {

    @Override
    public void addValue(Float value) {
        this.values.add(value);
    }

    @Override
    public ArrayList<Float> getValues() {
        return this.values;
    }
}