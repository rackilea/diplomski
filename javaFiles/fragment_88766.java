interface DbColumn {

    String getLabel();

    String getValue();
}

public enum Column implements DbColumn {

    NAME("m_Name", "Name"), ADDRESS("m_Address", "Address");

    private final String value;
    private final String label;

    private Column(String value, String label) {
        this.value = value;
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getValue() {
        return value;
    }
}

public class DynamicColumn implements DbColumn {

    private final String value;
    private final String label;

    private DynamicColumn(String value, String label) {
        this.value = value;
        this.label = label;
    }

    @Override
    public String getLabel() {
        return label;
    }

    @Override
    public String getValue() {
        return value;
    }

}