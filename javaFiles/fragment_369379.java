public String convertFile(HttpServletRequest request, HttpSession session) {
    // cast request
    MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
    // You can get your file from request
    CommonsMultipartFile multipartFile =  null; // multipart file class depends on which class you use assuming you are using org.springframework.web.multipart.commons.CommonsMultipartFile

    Iterator<String> iterator = multipartRequest.getFileNames();

    while (iterator.hasNext()) {
        String key = (String) iterator.next();
        // create multipartFile array if you upload multiple files
        multipartFile = (CommonsMultipartFile) multipartRequest.getFile(key);
    }

    // logic for conversion
}