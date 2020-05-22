IWorkbenchPage activePage = window.getActivePage();

IEditorPart activeEditor = activePage.getActiveEditor();

if (activeEditor != null) {
   IEditorInput input = activeEditor.getEditorInput();

   IProject project = input.getAdapter(IProject.class);
   if (project == null) {
      IResource resource = input.getAdapter(IResource.class);
      if (resource != null) {
         project = resource.getProject();
      }
   }
}