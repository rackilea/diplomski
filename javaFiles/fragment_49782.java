It would also crash in the streamCopy-fallback at the second location with a NPE because auf procect=null
    at line 439:
        private static OutputStream getOutputStream(Resource resource, boolean append, Project project)
            throws IOException {
        if (append) {
            Appendable a = resource.as(Appendable.class);
            if (a != null) {
                return a.getAppendOutputStream();
            }
            project.log("Appendable OutputStream not available for non-appendable resource "
                    + resource + "; using plain OutputStream", Project.MSG_VERBOSE);
        }
        return resource.getOutputStream();
    }