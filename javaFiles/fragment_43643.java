public void saveFilesToServer(String remoteDest, File localSrc) throws IOException {
    FTPClient ftp = new FTPClient();
    ftp.connect("ftp.foobar.com");
    if (!FTPReply.isPositiveCompletion(ftp.getReplyCode())) {
        ftp.disconnect();
        log.fatal("FTP not disconnected");
    }

    ftp.login("foo", "qwerty");
    log.info("Connected to server .");
    log.info(ftp.getReplyString());

    ftp.changeWorkingDirectory(remoteDest);
    ftp.setFileType(FTPClient.BINARY_FILE_TYPE);

    try {
        upload(localSrc, ftp);
    }
    finally {
        ftp.disconnect();
        log.info("FTP disconnected");           
    }
}

public void upload(File src, FTPClient ftp) throws IOException {
    if (src.isDirectory()) {
        ftp.makeDirectory(src.getName());
        ftp.changeWorkingDirectory(src.getName());
        for (File file : src.listFiles()) {
            upload(file, ftp);
        }
        ftp.changeToParentDirectory();
    }
    else {
        InputStream srcStream = null;
        try {
            srcStream = src.toURI().toURL().openStream();
            ftp.storeFile(src.getName(), srcStream);
        }
        finally {
            IOUtils.closeQuietly(srcStream);
        }
    }
}