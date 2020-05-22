protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    throws ServletException, IOException {

    // Your code to handle the request
    List<YourFileObject> responseFiles = ... // Whatever you need to do 

    // We declare that the response will contain raw bytes
    response.setContentType("application/octet-stream");

    // We open a ZIP output stream
    try (ZipOutputStream zipStream = new ZipOutputStream(response.getOutputStream()) {// This is Java 7, but not that different from java 6

        // We need to loop over each files you want to send
        for(YourFileObject fileToSend : responseFiles) {
            // We give a name to the file
            zipStream.putNextEntry(new ZipEntry(fileToSend.getName()));
            // and we copy its content
            copy(fileToSend, zipStream);
        }
    }
}