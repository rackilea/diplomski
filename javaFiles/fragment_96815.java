@Override
public void widgetSelected(SelectionEvent e) {

    // get the current editor
    Text text = (Text) editor.getEditor();

    if (text != null && !text.isDisposed()) {
        // update the text in the editor
        TreeItem row = cursor.getRow();
        int column = cursor.getColumn();
        text.setText(row.getText(column));
    }

    tree.setSelection(new TreeItem[] { cursor.getRow() });
}