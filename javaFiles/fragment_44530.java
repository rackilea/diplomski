ElementTreeSelectionDialog dialog = new ElementTreeSelectionDialog(
    shell, new WorkbenchLabelProvider(), new BaseWorkbenchContentProvider());
dialog.setInput(ResourcesPlugin.getWorkspace().getRoot());
dialog.setTitle("File selection");
dialog.setMessage("Choose a file");
dialog.setAllowMultiple(false);
// ...
dialog.addFilter(new ViewerFilter() {
    @Override
    public boolean select(Viewer viewer, Object parentElement, Object element) {
        return true;  // adapt to your need
    }
});
dialog.open();
IFile selectedFile = (IFile) dialog.getFirstResult();