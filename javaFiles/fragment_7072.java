comboBox.setEditor(new ItemEditor());

class ItemEditor extends BasicComboBoxEditor {
    public void setItem(Object anObject) {
        Item item = (Item) anObject;
        editor.setText(item.getId() + "");
    }
}