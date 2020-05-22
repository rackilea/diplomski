JEditorPane editorPane = new JEditorPane() {

    @Override
    public String getToolTipText(MouseEvent evt) {
        String text = null;
        int pos = viewToModel(evt.getPoint());
        if (pos >= 0) {
            HTMLDocument hdoc = (HTMLDocument) getDocument();
            javax.swing.text.Element e = hdoc.getCharacterElement(pos);
            AttributeSet a = e.getAttributes();

            SimpleAttributeSet value = (SimpleAttributeSet) a.getAttribute(HTML.Tag.A);
            if (value != null) {
                String href = (String) value.getAttribute(HTML.Attribute.HREF);
                if (href != null) {
                    text = href;
                }
            }
        }
        return text;
    }

};