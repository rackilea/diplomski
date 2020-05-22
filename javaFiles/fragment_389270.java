try {
            String ImageFile="", itemName = "";
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if (isMultipart) {
                FileItemFactory factory = new DiskFileItemFactory();
                ServletFileUpload upload = new ServletFileUpload(factory);
                List items = null;
                try {
                    items = upload.parseRequest(request);
                }
                catch (FileUploadException e) { 
                    e.getMessage();
                }

                Iterator itr = items.iterator();
                while (itr.hasNext()) {
                    FileItem item = (FileItem) itr.next();
                    if (item.isFormField()) {
                        String name = item.getFieldName();
                        String value = item.getString();
                        if(name.equals("ImageFile")) {
                            ImageFile=value;
                        }
                    }
                    else {
                        try {
                            itemName = item.getName();  
                            File savedFile = new File("config.getServletContext().getRealPath("/")+"Example\\image-folder\\"+itemName);
                            item.write(savedFile);
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        catch (Exception e) {
            out.println(e.getMessage());
        }