public static String fileToPath(String filename) throws UnsupportedEncodingException{
    URL url = MainTestCharm_saveToMemory.class.getResource(filename);

    if (url != null) {
        return java.net.URLDecoder.decode(url.getPath(),"UTF-8");
    }

    System.out.println("file: " + filename + "not found");
    System.exit(-1); // or return empty string or null
}