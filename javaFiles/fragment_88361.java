@Bean
    public FtpInboundFileSynchronizer ftpInboundFileSynchronizer() throws IOException {
        FtpInboundFileSynchronizer fileSynchronizer = new FtpInboundFileSynchronizer(ftpSessionFactory());
        fileSynchronizer.setDeleteRemoteFiles(false);
        fileSynchronizer.setRemoteDirectory("/");
        fileSynchronizer.setFilter(new FtpSimplePatternFileListFilter("*.xml"));

        ftpSessionFactory().getSession().mkdir("dir");
        final ByteArrayInputStream stream = new ByteArrayInputStream("foo".getBytes());
        ftpSessionFactory().getSession().write(stream, "dir/myFile.txt");
        return fileSynchronizer;
    }