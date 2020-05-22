protected void changeIvyClasspath(IProject project, IProgressMonitor monitor) throws CoreException {

    if(project.hasNature(JavaCore.NATURE_ID)){
        IJavaProject jproject = JavaCore.create(project);
        List<IClasspathEntry> iClasspathEntryList = new ArrayList<IClasspathEntry>();

        IClasspathEntry[] entries = jproject.getRawClasspath();
        for (IClasspathEntry entry : entries) {
            //exclude ivy.xml entries
            if (!entry.getPath().toString().contains("ivy.xml")) {
                iClasspathEntryList.add(entry);
            } 
        }

        //Add the ivy entries with the correct class path
        addIvyToClasspath(new String[] { "compile", "runtime" }, true, iClasspathEntryList, project, jproject, monitor);
        addIvyToClasspath(new String[] { "provided", "test" }, false, iClasspathEntryList, project, jproject, monitor);

        entries = iClasspathEntryList.toArray(new IClasspathEntry[iClasspathEntryList.size()]);

        jproject.setRawClasspath(entries, jproject.getOutputLocation(), null);
    }
}