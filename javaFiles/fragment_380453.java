@Resource // or whatever your framework needs
public class ModelBuilder {
    private int value;

    public ModelBuilder() {}

    public setValue(int value) {
        if(value < 1 || value > 99)
            throw new IllegalArgumentException("Value must be between 1 and 99 inclusive");
        this.value = value;
    }

    public Model build() {
        if (value == 0)
            throw new IllegalStateException("Value must be set before building.");
        return new Model(value);
}

public class Model {
    /**
     * 0 < value < 100
     */
    private final int value;

    public Model(int value) {
        if(value < 1 || value > 99)
            throw new IllegalArgumentException("Value must be between 1 and 99 inclusive");
        this.value = value;
    }

    // Other methods...
}