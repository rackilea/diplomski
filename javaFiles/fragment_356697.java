IStructuredSelection sel =   
     (IStructuredSelection)viewpart.getSite().getSelectionProvider().getSelection(); 

Object selObj = sel.getFirstElement();

IProject project =
   (IProject)Platform.getAdapterManager().getAdapter(selObj, IProject.class);

... might return null if selection is not the project

String name = project.getName();

IPath location = project.getLocation();