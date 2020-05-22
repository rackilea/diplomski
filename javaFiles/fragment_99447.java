JEditorPane pane = new JEditorPane(...);
...
Document doc = pane.getDocument();
if (doc instanceof PlainDocument) {
    doc.putProperty(PlainDocument.tabSizeAttribute, 8);
}
...