DefaultComboBoxModel model = (DefaultComboBoxModel)comboBox.getModel();

if (model.getIndexOf(theDate) == -1)
{
    comboBox.addItem( theDate );
}