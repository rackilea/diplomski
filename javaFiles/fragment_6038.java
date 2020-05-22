Object selectedItem = comboBox.getSelectedItem();
if (selectedItem != null)
{
    String selectedItemStr = selectedItem.toString();
    Foo(selectedItemStr); // Some method that takes a string parameter.
}