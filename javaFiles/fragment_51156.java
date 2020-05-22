@Override
public void setActiveEditor(IAction action, IEditorPart editorPart) {
    ((CompilationUnitEditor) editorPart).getViewer().addTextListener(new ITextListener() {

        @Override
        public void textChanged(TextEvent event) {
            selectedText = event.getText();
        }
    });

}