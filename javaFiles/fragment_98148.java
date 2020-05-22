//Handle File Upload for the attachment
           ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());

            try{
            List fileItemsList = servletFileUpload.parseRequest(request);

            //TODO: Take datafile input from the field and pass the file name so that we can view the file name

            Iterator it = fileItemsList.iterator();
            while (it.hasNext()){
              FileItem fileItem = (FileItem)it.next();
              if (fileItem.isFormField()){
                /* The file item contains a simple name-value pair of a form field */
              }
              else{ //do what you want with the file}