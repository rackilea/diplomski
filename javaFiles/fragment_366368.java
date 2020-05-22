FileEditorInput editorInput = new FileEditorInput(file);
IWorkbench wb = PlatformUI.getWorkbench();
IWorkbenchPage page = wb.getActiveWorkbenchWindow().getActivePage();
IEditorDescriptor desc = wb.getEditorRegistry().getDefaultEditor(file.getName());
IEditorPart editor = (IEditorPart)page.openEditor(editorInput, desc.getId());
ITextEditor textEditor = (ITextEditor) editor.getAdapter(ITextEditor.class);
IDocumentProvider documentProvider = textEditor.getDocumentProvider(); 
IDocument document = documentProvider.getDocument(editorInput);
document.replace(position, 0, content);