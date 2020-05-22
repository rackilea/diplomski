public class StringComboBoxModel extends AbstractListModel<String> implements ComboBoxModel<String> {

    private List<String> values;
    private String selectedItem;

    public StringComboBoxModel() {
        this(new ArrayList<String>(25));
    }

    public StringComboBoxModel(List<String> values) {
        this.values = values;
    }

    @Override
    public int getSize() {
        return values.size();
    }

    @Override
    public String getElementAt(int index) {
        return values.get(index);
    }

    @Override
    public void setSelectedItem(Object anItem) {
        if (anItem instanceof String) {
            selectedItem = (String) anItem;
        } else {
            selectedItem = null;
        }
    }

    @Override
    public Object getSelectedItem() {
        return selectedItem;
    }

    protected List<String> getValues() {
        return values;
    }

}

public class MutableStringComboBoxModel extends StringComboBoxModel {

    public MutableStringComboBoxModel() {
    }

    public MutableStringComboBoxModel(List<String> values) {
        super(values);
    }

    public boolean contains(String value) {
        return getValues().contains(value);
    }

    public void addValue(String value) {
        getValues().add(value);
        fireIntervalAdded(this, getSize() - 1, getSize() - 1);
    }

    public void replaceString(String oldString, String newString) {
        if (contains(oldString)) {
            int position = getValues().indexOf(oldString);
            getValues().set(position, newString);
            fireContentsChanged(this, position, position);
        } else {
            addValue(newString);
        }
    }

    // Other management methods...
}