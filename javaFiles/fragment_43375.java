List<TableEditor> editors = new ArrayList<>();
...
membersTable.removeAll();
editors.stream()                      // stream over TableEditors
       .map(TableEditor::getEditor)   // get their Editor (a Control)
       .forEach(Control::dispose);    // dispose it
editors.clear();