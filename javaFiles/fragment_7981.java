SVNRepository repository = SVNRepositoryFactory.create(SVNURL.parseURIDecoded(svnUrl));
        SVNDeltaGenerator deltaGenerator = new SVNDeltaGenerator();
        ISVNEditor editor = repository.getCommitEditor("This is a log message.", new CommitMediator());
        editor.openRoot(-1);
        editor.addFile("testThisTextCommit1.txt", null, -1);
        editor.applyTextDelta(svnUrl, null);
        InputStream is = SVNFileUtil.openFileForReading(file);
        String chksm = deltaGenerator.sendDelta(svnUrl, is, editor, true);

        is.close();
        editor.textDeltaEnd("testThisTextCommit1.txt");
        editor.closeFile("testThisTextCommit1.txt", chksm);
        editor.closeEdit();