public void send(List<Path> filesToSend, String destination) {
        logger.debug("Preparing to send ["+filesToSend.size()+"] files");

        if (sftpChannel == null) {
            logger.error("Failed to create SFTP channel");
        }

        int successCount = 0;
        int failedCount = 0;

        for (Path file : filesToSend) {
            try {
              send(file, destination);
              successCount++;
            } catch (Exception e) {
              failedCount++;
            }
        }
        //summary of sent files over sftpchannel
        logger.debug("Successfully sent " + successCount);
        logger.debug("Failed to sent " + failedCount);
    }