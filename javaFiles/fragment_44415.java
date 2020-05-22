public void run(IAction action) {
    //MessageDialog.openInformation(window.getShell(), "SO_GitPlugin", "Hello, Eclipse world");
    try {
        IProject selectedProject = ResourcesPlugin.getWorkspace().getRoot().getProject("SoccerTable");
        IJavaProject javaProject = JavaCore.create(selectedProject);
        IPackageFragment[] packages = javaProject.getPackageFragments();

        for (IPackageFragment mypackage : packages) {
            if (mypackage.getKind() == IPackageFragmentRoot.K_SOURCE) {
                for (ICompilationUnit unit : mypackage.getCompilationUnits()) {
                    IResource file = unit.getResource();
                    IFileRevision[] revisions = getFileRevisions(javaProject, file);
                    if (revisions != null && revisions.length > 0) {
                        for (IFileRevision revision : revisions) {
                            Method method = revision.getClass().getMethod("getRevCommit");
                            method.setAccessible(true);
                            RevCommit revCommit = (RevCommit) method.invoke(revision);
                            System.out.println(revision);
                            //System.out.println(revision.getComment());
                            System.out.println(revCommit.getFullMessage());
                            System.out.println("============================================");
                        }
                    }
                }
            }
        }
    }
    catch (Exception e) {
        e.printStackTrace();
    }
}