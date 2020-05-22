FileItemFactory factory = new DiskFileItemFactory();
    ServletFileUpload upload = new ServletFileUpload(factory);
    List items = null;
    try {
        items = upload.parseRequest(request);
    } catch (FileUploadException e) {
        e.printStackTrace();
    }
    Iterator itr = items.iterator();
    while (itr.hasNext()) {
        FileItem item = (FileItem) itr.next();
        if (item.isFormField()) {
        } else {
            try {
                String itemName = item.getName();
                String itemField = item.getFieldName();
                if (itemField.equals("datafile1")) {
                    // do things for left side
                } else if (itemField.equals("datafile2")) {
                    // do things for right side
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }