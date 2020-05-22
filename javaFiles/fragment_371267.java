ServletRequest request = (ServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
try
{
  if (!(request instanceof MultipartRequest))
  {
     request = unwrapMultipartRequest(request);
  }

  if (request instanceof MultipartRequest)
  {
     MultipartRequest multipartRequest = (MultipartRequest) request;

     String clientId = "upload";
     setFileData(multipartRequest.getFileBytes(clientId));
     setFileContentType(multipartRequest.getFileContentType(clientId));
     setFileName(multipartRequest.getFileName(clientId));
     saveOpenAttachment();
  }
}