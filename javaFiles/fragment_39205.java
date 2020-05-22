IMarker [] markers2 = resource2.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
if (markers2 != null) {
   for (IMarker m : markers2) {
     int sev = m.getAttribute(IMarker.SEVERITY, IMarker.SEVERITY_INFO);
     if (sev == IMarker.SEVERITY_ERROR) {
        System.out.println("Message: " + m.getAttribute(IMarker.MESSAGE));
        System.out.println("Line Number: " + m.getAttribute(IMarker.LINE_NUMBER));
     }
   }
}