import javax.swing.ComboBoxModel;

public class FilterableComboBoxModel<E> extends FilterableListModel<E> implements ComboBoxModel<E> {

    private FilterableComboBoxModel(ComboBoxModel<E> model) {
        super(model);
    }

    public ComboBoxModel<E> getComboBoxModel() {
        return (ComboBoxModel) getModel();
    }

    @Override
    public void setSelectedItem(Object anItem) {
        getComboBoxModel().setSelectedItem(anItem);
    }

    @Override
    public Object getSelectedItem() {
        return getComboBoxModel().getSelectedItem();
    }

}