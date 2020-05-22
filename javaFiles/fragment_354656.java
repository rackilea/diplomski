try {            
        ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
    } catch (IOException ex) {
        System.out.println("Error: " + ex.getMessage());
        ex.printStackTrace();
    }