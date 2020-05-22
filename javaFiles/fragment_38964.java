@Override
public void actionPerformed(ActionEvent e)
{
    Integer value = (Integer)comboBox.getSelectedItem();
    Action action = new StyledEditorKit.FontSizeAction("Font size", value);
    action.actionPerformed(null);
}