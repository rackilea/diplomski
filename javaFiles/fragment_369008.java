public class AStringAndAnInt{
    private StringProperty str = new SimpleStringProperty();
    private IntegerProperty integer = new SimpleIntegerProperty();

    public String getStr() {
        return str.getValue();
    }

    public void setStr(String value) {
        str.set(value);
    }

    public StringProperty strProperty() {
        return str;
    }

    public int getInteger() {
        return integer.getValue();
    }

    public void setInteger(int value) {
        integer.set(value);
    }

    public IntegerProperty integerProperty() {
        return integer;
    }
}