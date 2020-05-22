IWorkbenchPage page = activeWorkbenchPage();
if (page == null) {
    throw new RuntimeException();
}

IFile file;
IFile[] files = ResourcesPlugin.getWorkspace().getRoot()
            .findFilesForLocationURI(url.toURI());
file = files[0];

IMarker marker;
marker = file.createMarker(IMarker.TEXT);
HashMap<String, Object> map = new HashMap<String, Object>();
map.put(IMarker.LINE_NUMBER, lineNumber);
marker.setAttributes(map);
IDE.openEditor(page, marker);
marker.delete();