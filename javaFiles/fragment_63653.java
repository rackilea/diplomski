private FileEditorInput buildJSInput() throws CoreException {
    FileEditorInput ourInput = (FileEditorInput)getEditorInput().getAdapter(FileEditorInput.class);
    IFile ourFile = ourInput.getFile();
    // keep our temp file in the same directory as the DFD to avoid collisions
    IContainer parent = ourFile.getParent();

    IPath tmpPath = new Path( ourFile.getName() + "_tmpServerSideJS.js" ); //$NON-NLS-1$
    jsFile = parent.getFile(tmpPath);

    byte jsBytes[] = model.getModel().getServerScript().getBytes();
    InputStream jsIn = new ByteArrayInputStream(jsBytes);
    if (!jsFile.exists()) {
        jsFile.create(jsIn, IResource.HIDDEN, null);
    } else {
        jsFile.setContents(jsIn, 0, null);
    }


    return new FileEditorInput(jsFile);
}