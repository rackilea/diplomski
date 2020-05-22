public IFile findFileRecursively(IContainer container, String name) throws CoreException {
    for (IResource r : container.members()) {
        if (r instanceof IContainer) {
            IFile file = findFileRecursively((IContainer) r, name);
            if(file != null) {
                return file;
            }
        } else if (r instanceof IFile && r.getName().equals(name)) {
            return (IFile) r;
        }
    }

    return null;
}