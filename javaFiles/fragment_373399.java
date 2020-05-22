protected void load(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    RequestDispatcher dispatcher;   
    dispatcher= getServletContext().getRequestDispatcher("/Connection");

    // checks if the request actually contains upload file
            if (ServletFileUpload.isMultipartContent(request)) {

                // configures upload settings
                DiskFileItemFactory factory = new DiskFileItemFactory();
                // sets memory threshold - beyond which files are stored in disk
                factory.setSizeThreshold(MEMORY_THRESHOLD);
                // sets temporary location to store files
                factory.setRepository(new File(System.getProperty("java.io.tmpdir")));

                ServletFileUpload upload = new ServletFileUpload(factory);

                // sets maximum size of upload file
                upload.setFileSizeMax(MAX_FILE_SIZE);

                // sets maximum size of request (include file + form data)
                upload.setSizeMax(MAX_REQUEST_SIZE);

                // constructs the directory path to store upload file
                String uploadPath = getServletContext().getRealPath("")
                        + File.separator+UPLOAD_DIRECTORY;

                //Create dir if needed
                File uploadDir = new File(uploadPath);
                if (!uploadDir.exists()) {
                    uploadDir.mkdirs();
                }

                try {
                    // parses the request's content to extract file data
                    @SuppressWarnings("unchecked")
                    List<FileItem> formItems = upload.parseRequest(request);

                    if (formItems != null && formItems.size() > 0) {
                        // iterates over form's fields
                        for (FileItem item : formItems) {
                            // processes only fields that are not form fields
                            if (!item.isFormField() && item!=null) {
                                String fileName = new File(item.getName()).getName();
                                String fileNameToSave=FILE_NAME;

                                String filePath = uploadPath + File.separator + fileName;
                                String filePathToSave = uploadPath + File.separator + fileNameToSave;
                                FileNameExtensionFilter filterCSV=new FileNameExtensionFilter(null,"csv");
                                FileNameExtensionFilter filterXLS=new FileNameExtensionFilter(null,"xls");
                                File file= new File(filePath);

                                //Check file extension
                                if(filterCSV.accept(file)){

                                    File storeFile = new File(filePathToSave+".csv");                       
                                    //Save file on disk
                                    item.write(storeFile);
                                    Outils.importCSV(request);
                                }
                                if(filterXLS.accept(file)){

                                    File storeFile = new File(filePathToSave+".xls");                       
                                    //Save file on disk
                                    item.write(storeFile);
                                    Outils.importXLS(request);
                                }

                            }
                        }
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }