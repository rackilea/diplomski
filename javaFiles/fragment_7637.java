ftpClient.setFileType(FTPClient.BINARY_FILE_TYPE);                 
                    String remoteFileName = file.getName();
                    if (ftpClient.storeFile(remoteFileName, inputStream)) {
                        inputStream.close();
                        System.out.println("File " + file.getName() + " uploaded to server.");
                        isUploaded = true;
                    }