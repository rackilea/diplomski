public String upload() {
        try {
            File uploadedFile = File.createTempFile("image", ".tmp");

            InputStream content = file.getInputstream();

            Files.copy(content, uploadedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

            String filename = CloudinaryFacade.upload(uploadedFile);

            return Redirector.redirectWithMessage(filename, FacesMessage.SEVERITY_INFO, null);
        } catch (IOException ex) {
            return Redirector.redirectWithMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR, null);
        }
    }