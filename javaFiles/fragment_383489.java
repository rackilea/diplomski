private String getTextFromCursor() {
    IEditorPart part = PlatformUI.getWorkbench().getActiveWorkbenchWindow()
            .getActivePage().getActiveEditor();
    TextEditor editor = null;

    if (part instanceof TextEditor) {
        editor = (TextEditor) part;
    }

    if (editor == null) {
        return "";
    }

    StyledText text = (StyledText) editor.getAdapter(Control.class);

    int caretOffset = text.getCaretOffset();

    IDocumentProvider dp = editor.getDocumentProvider();
    IDocument doc = dp.getDocument(editor.getEditorInput());

    IRegion findWord = CWordFinder.findWord(doc, caretOffset);
    String text2 = "";
    if (findWord.getLength() != 0)
        text2 = text.getText(findWord.getOffset(), findWord.getOffset()
                + findWord.getLength() - 1);
    return text2;
}