public class UploadFileServiceImpl extends HttpServlet
    {
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException
        {
            response.setContentType("text/plain");

            try
            {
                FileItem uploadItem = getFileItem(request);
                if (uploadItem == null)
                {
                        // ERROR
                }   

                // Add logic here
            }
            catch (Exception ex)
            {
                response.getWriter().write("Error: file upload failure: " + ex.getMessage());           
            }
        }

        private FileItem getFileItem(HttpServletRequest request) throws FileUploadException
        {
            DiskFileItemFactory factory = new DiskFileItemFactory();        

             // Add here your own limit         
             factory.setSizeThreshold(DiskFileItemFactory.DEFAULT_SIZE_THRESHOLD);

         ServletFileUpload upload = new ServletFileUpload(factory);

             // Add here your own limit
             upload.setSizeMax(DiskFileItemFactory.DEFAULT_SIZE_THRESHOLD);


            List<?> items = upload.parseRequest(request);
            Iterator<?> it = items.iterator();
            while (it.hasNext())
            {
                FileItem item = (FileItem) it.next();
                        // Search here for file item
                if (!item.isFormField() && 
                  // Check field name to get to file item  ... 
                {
                    return item;
                }
            }

            return null;
        }
    }