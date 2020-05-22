ComboBoxEditor editor = comboForward.getEditor();
    JTextField textField = (JTextField) editor.getEditorComponent();
    ArrayList<String> autoCompleteList = new ArrayList<String>();
    for (Object item : comboForward.getItemList()) {
       autoCompleteList.add(item.toString());
    }

   AutoCompletion  autoCompletion = new AutoCompletion(textField, autoCompleteList);