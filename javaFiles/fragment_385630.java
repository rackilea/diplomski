public class ResourceChangeListener implements IResourceChangeListener {

    private Logger logger = Logger.getAnonymousLogger();

    public void resourceChanged(IResourceChangeEvent event) {
        IResourceDelta[] allChanges = event.getDelta().getAffectedChildren();

        for(IResourceDelta delta : allChanges) {
            if(delta.getKind() == 4) {  // only check projects when there are actual changes (4 = CHANGED)
                try {
                    // visits resource deltas
                    ResourceDeltaVisitor resourceDeltaVisitor = new ResourceDeltaVisitor();
                    delta.accept(resourceDeltaVisitor);
                    ArrayList<IResource> changedClasses = resourceDeltaVisitor.getChangedResources();

                    for(IResource changedClass : changedClasses) {
                        ICompilationUnit iCompilationUnit = (ICompilationUnit)JavaCore.create(changedClass);
                        // do something with ICompilationUnits...
                    }
                }
                catch (CoreException e1) {
                    // catch exception here
                }
            }
        }
    }

}