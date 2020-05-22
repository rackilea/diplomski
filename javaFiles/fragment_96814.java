@Override
public void widgetSelected(SelectionEvent e) {

    // get the current editor
    Text text = (Text) editor.getEditor();

    if (text != null && !text.isDisposed()) {
        // remove the editor
        text.dispose();  
    }

    tree.setSelection(new TreeItem[] { cursor.getRow() });
}