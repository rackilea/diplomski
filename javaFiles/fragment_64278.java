final SvnOperationFactory svnOperationFactory = new SvnOperationFactory();
    try {
        final ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        final SvnDiffGenerator diffGenerator = new SvnDiffGenerator();
        diffGenerator.setBasePath(new File(""));

        final SvnDiff diff = svnOperationFactory.createDiff();
        diff.setSources(SvnTarget.fromURL(url1, svnRevision1), SvnTarget.fromURL(url2, svnRevision1));
        diff.setDiffGenerator(diffGenerator);
        diff.setOutput(byteArrayOutputStream);
        diff.run();
    } finally {
        svnOperationFactory.dispose();
    }