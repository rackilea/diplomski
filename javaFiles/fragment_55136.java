private static void fill_repo(SVNRepository repo) throws SVNException {
        final SVNURL location = repo.getLocation();
        final SVNURL trunkUrl = SVNURL.parseURIEncoded(location + "/trunk");
        final SVNURL branchesUrl = SVNURL.parseURIEncoded(location + "/branches");
        SVNCommitInfo svnCommitInfo = makeDirectory(new SVNURL[]{trunkUrl, branchesUrl}, "commiting the directory");
        createNewFile("trunk", "new_file.txt", repo, "user_1", "");
        createNewFile("trunk", "test_file.txt", repo, "user_1", "");
        createNewFile("trunk", "another_file.txt", repo, "user_1", "");

        createBranchFromTrunk("Test_Branch", repo);
        createBranchFromTrunk("Second_Branch", repo);

        addContentToFile(repo, "branches/Test_Branch/test_file.txt", "Test Text");

    }


    private static void createNewFile(String dir, String filename, SVNRepository repo, String username, String password) throws SVNException {

        ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager(username, password);
        repo.setAuthenticationManager(authManager);

        ISVNEditor editor = repo.getCommitEditor("creating a new file", null /*locks*/, true /*keepLocks*/, null /*mediator*/);
        editor.openRoot(-1);
        editor.openDir(dir, -1);
        editor.addFile(dir + "/" + filename, null, -1);
        editor.closeFile(dir + "/" + filename, "checksum");
        editor.closeEdit();
    }


    private static void createBranchFromTrunk(String branchName, SVNRepository repo) throws SVNException {

        final SVNClientManager svnClientManager = SVNClientManager.newInstance();
        final SVNCopyClient copyClient = svnClientManager.getCopyClient();
        final SVNURL location = repo.getLocation();
        final SVNURL srcURL = SVNURL.parseURIEncoded(location + "/trunk");
        final SVNURL dstURL = SVNURL.parseURIEncoded(location + "/branches/" + branchName);

        final SVNCopySource source = new SVNCopySource(SVNRevision.HEAD, SVNRevision.HEAD, srcURL);
        copyClient.doCopy(new SVNCopySource[]{source}, dstURL, false, false, true, "Create new Branch", null);
    }


    private static SVNCommitInfo addContentToFile(SVNRepository repos, String pathToFile, String content) throws SVNException {
        InputStream newContents = new ByteArrayInputStream(content.getBytes());
        ISVNEditor editor = repos.getCommitEditor("", null);
        editor.openRoot(-1);
        editor.openFile(pathToFile, -1);
        editor.applyTextDelta(pathToFile, null);
        String checksum = new SVNDeltaGenerator().sendDelta(pathToFile, newContents, editor, true);
        editor.closeDir();
        SVNCommitInfo info = editor.closeEdit();
        return info;
    }