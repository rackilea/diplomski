File file = .... the file to open

IFileStore fileStore = EFS.getStore(file.getURI());

IEditorInput editorInput = new FileStoreEditorInput(fileStore);

IWorkbenchPage page = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();

page.openEditor(editorInput, "id of editor to open");