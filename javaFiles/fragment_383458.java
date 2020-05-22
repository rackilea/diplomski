IClasspathEntry entry = ....

IWorkbenchRoot root = ResourcesPlugin.getWorkspace().getRoot();

if (entry.getEntryKind() == IClasspathEntry.CPE_LIBRARY) {
    IPath cpPath = entry.getPath();

    IResource res = root.findMember(cpPath);

    // If res is null, the path is absolute (it's an external jar)

    String path;
    if (res == null) {
        path = cpPath.toOSString();
    }
    else {
        // It's relative
        path res.getLocation().toOSString();
    }
}