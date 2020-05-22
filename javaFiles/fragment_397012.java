IProject project = ...

IFile manifestResource = project.getFile(new Path("META-INF/MANIFEST.MF"));
if (manifestResource.exists()) {
    try (InputStream stream = manifestResource.getContents()) {
        Manifest manifest = new Manifest();
        manifest.read(stream);

        String symbolicName = manifest.getMainAttributes().getValue("Bundle-SymbolicName");
    } catch (CoreException | IOException ex) {
       ...
    }
}