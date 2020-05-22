class MyNewFileWizardPage extends NewSourceFileCreationWizardPage{

   private ITranslationUnit fNewFileTU = null;

   @SuppressWarnings("restriction")
   public IFile createMyFile(Template template, IPath filePath, IProgressMonitor monitor) throws CoreException {
    if (filePath != null) {
        if (monitor == null)
            monitor = new NullProgressMonitor();
        try {
            fNewFileTU = null;
            IFile newFile = NewSourceFileGenerator.createSourceFile(filePath, true, monitor);
            if (newFile != null) {
                fNewFileTU = (ITranslationUnit) CoreModel.getDefault().create(newFile);
                if (fNewFileTU != null) {
                    String lineDelimiter = StubUtility.getLineDelimiterUsed(fNewFileTU);
                    String content = CodeGeneration.getBodyFileContent(template, fNewFileTU, null, null, lineDelimiter);
                    if (content != null) {
                        fNewFileTU.getBuffer().setContents(content.toCharArray());
                        fNewFileTU.save(monitor, true);
                        return newFile;
                    }
                }
            }
        } finally {
            monitor.done();
        }
    }
    return null;
  }
}