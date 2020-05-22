final SvnOperationFactory svnOperationFactory = new SvnOperationFactory();
    try {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final SvnDiffGenerator diffGenerator = new SvnDiffGenerator();
        diffGenerator.setBasePath(new File(""));

        final SvnDiff diff = svnOperationFactory.createDiff();
        diff.setSources(SvnTarget.fromURL(url, SVNRevision.create(revision1)), url, SVNRevision.create(revision2)));
        diff.setDiffGenerator(diffGenerator);
        diff.setOutput(byteArrayOutputStream);
        diff.run();
    } finally {
        svnOperationFactory.dispose();
    }