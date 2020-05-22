public static String getWebContentPath(String contextPath) throws UnsupportedEncodingException {

    String path = PathUtils.class.getClassLoader().getResource("").getPath();
    String fullPath = URLDecoder.decode(path, "UTF-8");
    if(fullPath.contains("/WEB-INF/classes")){
        String pathArr[] = fullPath.split("/classes/");
        fullPath=pathArr[0];
    }
    String reponsePath = "";
    reponsePath = new File(fullPath).getPath() + File.separatorChar + "php"+File.separatorChar+contextPath;
    return reponsePath;
}