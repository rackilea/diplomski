protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     DiskFileItemFactory disk = new DiskFileItemFactory();
     disk.setRespository(new File(TEMP_STORAGE));

     ServletFileUpload upload = new ServletFileUpload(disk);
     upload.setFileSizeMax(MAX_FILE_SIZE);
     List<FileItem> files = upload.parseRequest(request);

     //...get actual file with files.get(index).getInputStream() and process them....
     .....
}