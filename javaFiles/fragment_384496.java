ITextEditor editor = (ITextEditor) editorPart;
 IDocument document = editor.getDocumentProvider().getDocument(
 editor.getEditorInput());
 if (document != null) {
 IRegion lineInfo = null;
  try {
  // line count internaly starts with 0, and not with 1 like in
  // GUI
   lineInfo = document.getLineInformation(lineNumber - 1);
 } catch (BadLocationException e) {
  // ignored because line number may not really exist in document,
  // we guess this...
 }
  if (lineInfo != null) {
  editor.selectAndReveal(lineInfo.getOffset(), lineInfo.getLength());
   }
}