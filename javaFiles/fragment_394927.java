public List<ProcessedFile> uploadFTPFilesByCridational(List<ProcessedFile> processedFiles, String sourceDir,
            String destinationPath, String hostName, String userName, String password, String portNo, String extation,
            int fileHours, int fileMint) {
        List<ProcessedFile> processedFilesList = new ArrayList<>();
        try {
            FTPClient ftpClient = new FTPClient();

            // client FTP connection
            ftpClient = connectToFTPClient(hostName, userName, password, portNo);

            // check if FTP client is connected or not
            if (ftpClient.isConnected()) {

                if (processedFiles != null && processedFiles.size() > 0) {
                    for (ProcessedFile processedFile : processedFiles) {
                        FileInputStream inputStream = null;
                        try {
                            File file = new File(sourceDir + "/" + processedFile.getOriginalFileName());
                            inputStream = new FileInputStream(file);

                            if (!ftpClient.isConnected()) {
                                ftpClient = connectToFTPClient(hostName, userName, password, portNo);
                            }

                            ByteArrayInputStream in = null;
                            try {
                                ftpClient.changeWorkingDirectory(destinationPath);
                                ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
                                ftpClient.setFileTransferMode(FTP.BINARY_FILE_TYPE);
                                ftpClient.enterLocalPassiveMode();
                                in = new ByteArrayInputStream(FileUtils.readFileToByteArray(file));
                                ftpClient.storeFile(file.getName(), in);
                            } catch (Exception e) {
                                logger.error(e.getMessage());
                            }

                            inputStream.close();
                            in.close();

                            processedFile.setProcessedStatus(ProcessedStatus.COMPLETED);
                            processedFilesList.add(processedFile);
                        } catch (Exception e) {
                            logger.error(e);
                            processedFile.setProcessedStatus(ProcessedStatus.FAILED);
                            processedFilesList.add(processedFile);
                        }
                    }
                }
            }
            if (ftpClient.isConnected()) {
                try {
                    ftpClient.logout();
                    ftpClient.disconnect();
                } catch (IOException e) {
                    logger.error(e.getMessage());
                } finally {
                    try {
                        ftpClient.disconnect();
                    } catch (Exception e) {
                        logger.error(e.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            logger.error("FTP not connected exception: " + e);
        }
        return processedFilesList;
    }