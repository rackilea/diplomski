public class DefaultNumberModel extends AbstractNumberModel {

    private int value;

    public DefaultNumberModel() {
    }

    public DefaultNumberModel(int value) {
        setValue(value);
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void setValue(int num) {
        if (num != value) {
            value = num;
            fireStateChanged();
        }
    }

}