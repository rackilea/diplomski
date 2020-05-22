File actualFile = new File(pathToFile);
if (actualFile.exists()){
    try {
        response.setContentType("image/png");
        response.setHeader("Content-Length", String.valueOf(actualFile.length()));
        InputStream in = new FileInputStream(pathToFile);
        IOUtils.copy(in, response.getOutputStream());
    }
    catch (Exception e){
        ...
    }
}