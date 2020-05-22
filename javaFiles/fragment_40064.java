//box.addActionListener(new EventComboBoxListener(box));
ComboBoxEditor editor = box.getEditor();
JTextField textField = (JTextField)editor.getEditorComponent();

textField.addActionListener( new ActionListener()
{
    @Override
    public void actionPerformed(ActionEvent e)
    {
        String item = textField.getText();
        DefaultComboBoxModel model = (DefaultComboBoxModel)box.getModel();

        if (model.getIndexOf(item) == -1)
        {
            box.addItem(item);
            box.setSelectedIndex( box.getItemCount() - 1 );
        }
    }
});