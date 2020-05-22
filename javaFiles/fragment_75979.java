for (int i = 0; i < items.length; i++) {
    final CCombo templateDropdown = new CCombo(right_group_table, SWT.NONE);
    templateDropdown.setText("CCombo");
    templateDropdown.add("item 1");
    templateDropdown.add("item 2");
    final TableEditor editor = new TableEditor(right_group_table);
    editor.grabHorizontal = true; // <-- Here
    editor.setEditor(templateDropdown, items[i], 1);
}