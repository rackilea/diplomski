public void exportFromSvn(SVNClientManager clientManager) throws SVNException {
        SVNUpdateClient updateClient = clientManager.getUpdateClient();
        SVNURL url = SVNURL.parseURIDecoded("<svn url to export from>");
        //destination path
        File dstPath = new File("LocalDirNew");
        //the revision number which should be looked upon for the file path
        SVNRevision pegRevision = SVNRevision.create(<right svn revision number>);
        //the revision number which is required to be exported.
        SVNRevision revision = SVNRevision.create(<right svn revision number>);
        //if there is any special character for end of line (in the file) then it is required. For our use case, //it can be null, assuming there are no special characters. In this case the OS specific EoF style will //be assumed
        String eolStyle = null;
        //this would force the operation
        boolean force = true;
        //Till what extent under a directory, export is required, is determined by depth. INFINITY means the whole subtree of that directory will be exported
        SVNDepth recursive = SVNDepth.INFINITY;
        updateClient.doExport(url, dstPath, pegRevision, revision, eolStyle, force, recursive );
    }