if(ServletFileUpload.isMultipartContent(request)){
   try {
            List<FileItem> multiparts = new ServletFileUpload(
                                     new DiskFileItemFactory()).parseRequest(request);

            for(FileItem item : multiparts){
                if(!item.isFormField()){
                    String name = new File(item.getName()).getName();
                    item.write( new File(UPLOAD_DIRECTORY + File.separator + name));
                }
            }
           //File uploaded successfully
           request.setAttribute("message", "File Uploaded Successfully");
        } catch (Exception ex) {
           request.setAttribute("message", "File Upload Failed due to " + ex);
        }        
     }