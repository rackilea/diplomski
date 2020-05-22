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
            // Send the file stream and file name to the storage bucket...
            GoogleStorage.sendFileToBucket(fileStream, fileName);

        ...
    }
}