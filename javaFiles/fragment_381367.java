import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.servlet.ServletRequestContext;

Code
@ResourceMapping(value = "uploadfile")
    public void processUploadedFile(final ResourceRequest request, final ResourceResponse response, final PortletRequest portletRequest){

HttpServletRequest originalHttpServletRequest = (HttpServletRequest) (com.ibm.ws.portletcontainer.portlet.PortletUtils.getHttpServletRequest(request));
        final boolean multipartContent = FileUploadBase.isMultipartContent(new ServletRequestContext(originalHttpServletRequest));

        if (multipartContent) {
            file= createPEService.getResourceToBeUploaded(originalHttpServletRequest,file,bytes);
        }
}