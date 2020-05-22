import org.springframework.beans.factory.FactoryBean;

public class Vector3DFactoryBean implements FactoryBean<Vector3D> {
    private String delimiter;
    private String value;
    private transient Vector3D instance;

    public String getDelimiter() { return delimiter; }
    public void setDelimiter(String delimiter) { this.delimiter = delimiter; }
    public String getValue() { return value; }
    public void setValue(String value) { this.value = value; }

    @Override
    public Vector3D getObject() {
        if (instance == null) {
            String[] values = value.split(delimiter);
            instance = new Vector3D(
                                    Double.parseDouble(values[0]),
                                    Double.parseDouble(values[1]),
                                    Double.parseDouble(values[2])
                                   );
        }
        return instance;
    }
    @Override
    public Class<?> getObjectType() {
        return Vector3D.class;
    }
    @Override
    public boolean isSingleton() {
        return true;
    }
}