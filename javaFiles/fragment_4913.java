public class UploadServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        // process only if its multipart content
        RequestContext reqContext = new ServletRequestContext(request);
        if (ServletFileUpload.isMultipartContent(reqContext)) {
            try {
                List<FileItem> multiparts = new ServletFileUpload(
                        new DiskFileItemFactory()).parseRequest(request);
                ArrayList<FileItem> fileList = new ArrayList<FileItem>();
                request.setAttribute("files", fileList);
                for (FileItem item : multiparts) {
                    if (!item.isFormField()) {
                        fileList.add(item);
                    } else {
                        request.setAttribute(item.getFieldName(),
                                item.getString());
                    }
                }

                request.setAttribute("message", "success");
            } catch (Exception ex) {
                request.setAttribute("message", "fail"
                        + ex);
            }

        } else {
            request.setAttribute("message",
                    "notMultipart");
        }

        System.out.println(request.getRequestURI().substring(request.getRequestURI().indexOf("upload")+6));

        String forwardUri = "/api" + request.getRequestURI().substring(request.getRequestURI().indexOf("upload")+6);

        request.getRequestDispatcher(forwardUri)
                .forward(request, response);

    }

}