/**
 * @see HttpServlet#HttpServlet()
 */
public UploadServlet() {
    super();
    // TODO Auto-generated constructor stub
}

/**
 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
 */
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

}

/**
 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
 */
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       File file = null ;
       int maxFileSize = 5000 * 1024;
       int maxMemSize = 8000 * 1024;
       ServletContext context = request.getServletContext();
       String filePath = context.getInitParameter("file-upload");
       // Verify the content type
       String contentType = request.getContentType();
       if ((contentType.indexOf("multipart/form-data") >= 0)) {

          DiskFileItemFactory factory = new DiskFileItemFactory();
          // maximum size that will be stored in memory
          factory.setSizeThreshold(maxMemSize);
          // Location to save data that is larger than maxMemSize.
          factory.setRepository(new File("c:\\temp"));

          // Create a new file upload handler
          ServletFileUpload upload = new ServletFileUpload(factory);
          // maximum file size to be uploaded.
          upload.setSizeMax( maxFileSize );
          try{ 
             // Parse the request to get file items.
             List fileItems = upload.parseRequest(request);

             // Process the uploaded file items
             Iterator i = fileItems.iterator();


             while ( i.hasNext () ) 
             {
                FileItem fi = (FileItem)i.next();
                if ( !fi.isFormField () )   
                {
                // Get the uploaded file parameters
                String fieldName = fi.getFieldName();
                String fileName = fi.getName();
                boolean isInMemory = fi.isInMemory();
                long sizeInBytes = fi.getSize();
                // Write the file
                if( fileName.lastIndexOf("\\") >= 0 ){
                file = new File( filePath + 
                fileName.substring( fileName.lastIndexOf("\\"))) ;
                }else{
                file = new File( filePath + 
                fileName.substring(fileName.lastIndexOf("\\")+1)) ;
                }
                fi.write( file ) ;
                }
             }
             // code for xlsx files
            InputStream ExcelFileToRead = new FileInputStream(file);
            XSSFWorkbook  wb = new XSSFWorkbook(ExcelFileToRead);
            XSSFWorkbook test = new XSSFWorkbook(); 
            XSSFSheet sheet = wb.getSheetAt(0);
            XSSFRow row; 
            XSSFCell cell;
            Iterator rows = sheet.rowIterator();
                String columns = "";
                row=(XSSFRow) rows.next();
                Iterator cells = row.cellIterator();
                while (cells.hasNext())
                {
                    cell=(XSSFCell) cells.next();
                    columns += cell+",";
                }


                request.setAttribute("columns", columns);
                HttpSession session=request.getSession(true); 
                session.setAttribute("file",file);

                RequestDispatcher reqDispatcher = getServletConfig().getServletContext().getRequestDispatcher("/excel.jsp");
                reqDispatcher.forward(request,response);
          }catch(Exception ex) {
             ex.printStackTrace();
          }
       }
}