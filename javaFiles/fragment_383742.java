public SVNClientManager getSVNClientManager () throws IOException{
             SVNURL url = SVNURL
                  .parseURIDecoded("<path to the base svn repository>");                    
             SVNRepository repository = SVNRepositoryFactory.create(url, null);
             ISVNOptions myOptions = SVNWCUtil.createDefaultOptions(true);
            //provide svn username and password
            //username = name used to connect to svn
            //password = password used to connect to svn
            ISVNAuthenticationManager myAuthManager = SVNWCUtil
                .createDefaultAuthenticationManager("<username>", "<password>");
           repository.setAuthenticationManager(myAuthManager);
        //clientManager will be used to get different kind of svn clients instances to do different activities
       //like update, commit, view diff etc.
        SVNClientManager clientManager = SVNClientManager.newInstance(
                myOptions, myAuthManager);

return clientManager ;
}