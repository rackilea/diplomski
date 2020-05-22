public class Row {
    private final StringProperty label = new SimpleStringProperty() ;
    public StringProperty labelProperty() {
        return label ;
    }
    public final String getLabel() {
        return labelProperty().get();
    }
    public final void setLabel(String label) {
        labelProperty().set(label);
    }

    public final StringProperty type = new SimpleStringProperty();
    public StringProperty typeProperty() {
        return type ;
    }
    public final String getType() {
        return typeProperty().get();
    }
    public final void setType(String type) {
       typeProperty().set(type);
    }
}