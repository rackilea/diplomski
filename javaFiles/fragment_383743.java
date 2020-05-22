public void commitToSvn(SVNClientManager clientManager)
            throws SVNException {
        SVNCommitClient commitClient = clientManager.getCommitClient();
        File fileToCheckin = new File("LocalDir/SampleFileFolder/SampleFile1");
        boolean recursive = true;       
       SVNCommitInfo importInfo = commitClient
                .doImport(
                        fileToCheckin ,
                        SVNURL.parseURIDecoded("<path at which we want to check-in the file>"),
                        "testing svn kit integration", recursive);
        System.out.println(importInfo.getNewRevision());
    }