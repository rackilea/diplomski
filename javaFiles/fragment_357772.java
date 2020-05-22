IFile file = .... get file to mark 

IMarker marker = file.createMarker(IMarker.PROBLEM);

marker.setAttribute(IMarker.LINE_NUMBER, line number);
marker.setAttribute(IMarker.MESSAGE, "error message");
marker.setAttribute(IMarker.SEVERITY, IMarker.SEVERITY_ERROR);