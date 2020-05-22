static String getMimeType(String fileName) {
    // 1. first use java's built-in utils
    FileNameMap mimeTypes = URLConnection.getFileNameMap();
    String contentType = mimeTypes.getContentTypeFor(fileName);

    // 2. nothing found -> lookup our in extension map to find types like ".doc" or ".docx"
    if (contentType == null) {
        String extension = fileName.substring(fileName.lastIndexOf('.') + 1, fileName.length());;
        contentType = fileExtensionMap.get(extension);
    }
    return contentType;
}