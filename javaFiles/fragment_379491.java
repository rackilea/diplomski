@RequestMapping(value = "xxx.iso", method = { RequestMethod.HEAD })
public void doChunkedHEAD(HttpServletResponse response) {

    try {
        String localAppRootPath = servletContext.getRealPath("/");
        Path filePath = Paths.get(localAppRootPath, "xxx.iso");
        File fileObj = new File(filePath.toString());
        long fileSize = fileObj.length();
        response.setHeader("Content-Length", String.valueOf(fileSize));
    } catch (Exception e) {

    }
}