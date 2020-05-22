public class ComboItem {
    private String id;
    private String name;

    public ComboItem(String id, String name) {
        this.id = id;
        this.name = name;
    }

    // Add the getter and setter as you want.

    // This will be used internally by JComboBox as the label to be displayed.
    @Override
    public String toString() {
        return name;
    }
}