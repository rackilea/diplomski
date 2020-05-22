try {
    Logger.info("AdultPTPController: Starting File Upload...");
    File file = null;
    File fileFinal = null;
    String fileName = "";
    String fileContentType = "";
    String filePath = "";
    String fileID = "";
    String bucketFilePath = "";
    String bucketFileName = "";
    // String folderIDToFind =
    // adultDemo.getNew_Provider_Id().toString();
    String folderIDToFind = adultDemo.getLegacy_Provider_Id().toString();
    Http.MultipartFormData<File> formData = request().body().asMultipartFormData();
    if (formData != null) {
        Http.MultipartFormData.FilePart<File> filePart = formData.getFile("fileAttach");
        if (filePart != null) {
            fileName = filePart.getFilename().trim();
            // Is there a file?
            if (!fileName.equals("") && fileName != null) {
                Logger.info("AdultPTPController: File Name = " + fileName);
                fileContentType = filePart.getContentType();
                file = filePart.getFile();
                long size = Files.size(file.toPath());
                String fullFilePath = file.getPath();
                InputStream fileStream = new FileInputStream(fullFilePath);
                // Send the file/multipart content to the storage
                // bucket...
                Logger.info("AdultPTPController: Sending file to GoogleStorage - sendFileToBucket");
                File bucketFile = GoogleControl.sendFileToBucket(fileStream, fileName);
                //File bucketFile = null;
                Logger.info("AdultPTPController: File Sent to GoogleStorage - sendFileToBucket");

                // Send the file to Google Drive...
                if (bucketFile != null) {
                    // Upload the file and return the file ID...                            
                    Logger.info("AdultPTPController: File is not null, sending to uploadFile...");
                    bucketFileName = bucketFile.getName();
                    Logger.info("AdultPTPController: bucketFileName = " + bucketFileName);
                    fileID = GoogleControl.uploadFile(bucketFile, folderIDToFind);
                    Logger.info("AdultPTPController: File ID = " + fileID);
                    if (!fileID.equals("")) {
                        // Success...
                        // Create a file record...
                        FileUpload fileUpload = new FileUpload();
                        // Create a unique ID...
                        fileUpload.setFileKey(fileUpload.createFileKey());
                        // Set the needed fields...
                        fileUpload.setRecordID(adultDemo.getLegacy_Provider_Id().toString());
                        fileUpload.setRecordKey(adultPTP.getPtpkey());
                        fileUpload.setCreatedBy(user.getFullname());
                        fileUpload.setCreatedByEmail(user.getEmail());
                        fileUpload.setCreatedByKey(user.getUserkey());
                        fileUpload.setCreatedDate(GlobalUtilities.getCurrentLocalDateTime());
                        fileUpload.setDateCreatedDisplay(
                                GlobalUtilities.getStringDate(fileUpload.getCreatedDate()));
                        // Set the file info...
                        fileUpload.setFileID(fileID);
                        fileUpload.setFileName(fileName);
                        fileUpload.setFilePath(filePath);
                        String folderID = Configuration.root().getString("google.drive.folderid");
                        fileUpload.setFolderID(folderID);
                        // Set the URL...
                        String urlString = Configuration.root().getString("server.hostname");
                        String fullURL = urlString + "/downloadfile?ptpKey=" + adultPTP.getPtpkey() + "&fileID="
                                + fileID;
                        fileUpload.setFileURL(fullURL);
                        fileUpload.save();
                    }
                }
            }
        }
    }
} catch (Exception e) {
    e.printStackTrace();
}