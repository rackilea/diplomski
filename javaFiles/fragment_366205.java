protected void processRequest(HttpServletRequest request, HttpServletResponse response)      throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    OutputStream writer = response.getOutputStream();
    :
    //Write the CSV file header 
    //(no change from your code here.)
    CSVUtils.writeLine(writer,Arrays.asList("NAME","email"));