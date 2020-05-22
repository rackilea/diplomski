public String getCurrentEditorContent() {
    final IEditorPart activeEditor = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
            .getActiveEditor();
    if (activeEditor == null)
        return null;
    final IDocument doc = (IDocument) activeEditor.getAdapter(IDocument.class);
    if (doc == null) return null;

    return doc.get();
}