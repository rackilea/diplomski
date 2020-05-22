public String fileUpload(RequestContext requestContext) {
    final ServletExternalContext context = (ServletExternalContext) requestContext.getExternalContext();
    final MultipartHttpServletRequest multipartRequest = new StandardMultipartHttpServletRequest((HttpServletRequest)context.getNativeRequest());
    final File file = multipartRequest.getFile("file");
    fileUploadHandler.processFile(file); //do something with the submitted file
}