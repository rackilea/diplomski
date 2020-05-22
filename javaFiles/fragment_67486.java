DiskFileItemFactory factory = new DiskFileItemFactory();

// Set factory constraints
factory.setSizeThreshold(yourMaxMemorySize);
factory.setRepository(yourTempDirectory);

// Create a new file upload handler
ServletFileUpload upload = new ServletFileUpload(factory);

// Set overall request size constraint
upload.setSizeMax(yourMaxRequestSize);

// Parse the request
List /* FileItem */ items = upload.parseRequest(request);