Editor[] editors = EditorFactory.getInstance().getAllEditors();
    FileDocumentManager fileDocManager = FileDocumentManager.getInstance();
    for(Editor editor : editors) {
        VirtualFile vf = fileDocManager.getFile(editor.getDocument());
        String path = vf.getCanonicalPath();
        System.out.println("path = " + path);
    }