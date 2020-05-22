FTPClient ftp = new FTPClient();
    ftp.connect("ftp.ncbi.nih.gov");
    ftp.login("anonymous", "");
    ftp.setFileType(FTP.BINARY_FILE_TYPE);
    InputStream is = new GZIPInputStream(ftp.retrieveFileStream("/genbank/gbbct1.seq.gz"));

    try {
        byte[] buffer = new byte[65536];
        int noRead;

        while ((noRead = is.read(buffer)) != 1) {
            System.out.write(buffer, 0, noRead);
        }
    } finally {
        is.close();
        ftp.disconnect();
    }
}