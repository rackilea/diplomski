DiskFileItemFactory factory = new DiskFileItemFactory();
ServletFileUpload fileUpload = new ServletFileUpload(factory);
List<FileItem> fileUploadItems = fileUpload.parseRequest((HttpServletRequest) request);
for (FileItem fileItem : fileUploadItems) {
    String fieldName = fileItem.getFieldName();
    String contentType = fileItem.getContentType();
    long size = fileItem.getSize();
    if (size < 1) {
        throw new FileUploadException("The submitted file must not be null!");
    }
    boolean equalFieldName = fieldName.equals(SOME_FIELD_NAME);
    if (!equalFieldName) {
        // do something
    }
    boolean equalContentType = contentType.equals(SOME_CONTENT);
    if (!equalContentType) {
        // do something
    }
    if (equalFieldName && equalContentType) {
         stream = fileItem.getInputStream();
         break;
    }

}