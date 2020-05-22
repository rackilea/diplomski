private class FontSizeAction extends HTMLEditorKit.FontSizeAction {
    private int size;

    public FontSizeAction(int size) {
        super("font-size-" + size, size);
        this.size = size;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        JEditorPane editor = getEditor(ae);
        if (size > 0) {
           MutableAttributeSet attr = new SimpleAttributeSet();
           attr.addAttribute(StyleConstants.FontSize, size + "pt");
           setCharacterAttributes(editor, attr, false);
        } else UIManager.getLookAndFeel().provideErrorFeedback(editor);   
    }
}